const storageKey = 'addressBookContacts';
const contactForm = document.getElementById('contact-form');
const contactList = document.getElementById('contact-list');
const formStatus = document.getElementById('form-status');
const contactCount = document.getElementById('contact-count');
const searchInput = document.getElementById('search-input');
const filterCategory = document.getElementById('filter-category');
const clearStorageButton = document.getElementById('clear-storage');
const exportJsonButton = document.getElementById('export-json');
const importJsonButton = document.getElementById('import-json');

let contacts = [];
let editingId = null;

function createId() {
  return `c-${Date.now()}-${Math.floor(Math.random() * 1000)}`;
}

function saveContacts() {
  localStorage.setItem(storageKey, JSON.stringify(contacts));
}

function loadContacts() {
  const saved = localStorage.getItem(storageKey);
  if (!saved) return [];
  try {
    const parsed = JSON.parse(saved);
    return Array.isArray(parsed) ? parsed : [];
  } catch {
    return [];
  }
}

function updateContactCount() {
  const count = filteredContacts().length;
  contactCount.textContent = `${count} contact${count === 1 ? '' : 's'}`;
}

function filteredContacts() {
  const query = searchInput.value.trim().toLowerCase();
  const category = filterCategory.value;

  return contacts.filter(contact => {
    const matchesQuery = [contact.name, contact.email, contact.phone, contact.address, contact.category]
      .some(value => value.toLowerCase().includes(query));

    const matchesCategory = category === 'all' || contact.category === category;
    return matchesQuery && matchesCategory;
  });
}

function renderContacts() {
  const list = filteredContacts();
  contactList.innerHTML = '';

  if (list.length === 0) {
    contactList.innerHTML = '<p class="empty-state">No contacts found. Add one to begin.</p>';
    updateContactCount();
    return;
  }

  list.forEach(contact => {
    const card = document.createElement('article');
    card.className = 'contact-card';
    card.innerHTML = `
      <strong>${escape(contact.name)}</strong>
      <div class="contact-tags"><span class="tag">${escape(contact.category)}</span></div>
      <div class="contact-meta">
        <span>Email: ${escape(contact.email)}</span>
        <span>Phone: ${escape(contact.phone)}</span>
        <span>Address: ${escape(contact.address || 'N/A')}</span>
      </div>
      <div class="card-actions">
        <button class="edit" data-id="${contact.id}">Edit</button>
        <button class="delete" data-id="${contact.id}">Delete</button>
      </div>
    `;

    contactList.appendChild(card);
  });

  updateContactCount();
}

function escape(value) {
  return String(value).replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
}

function resetForm() {
  contactForm.reset();
  editingId = null;
  document.getElementById('save-button').textContent = 'Save Contact';
}

function populateForm(contact) {
  document.getElementById('name').value = contact.name;
  document.getElementById('email').value = contact.email;
  document.getElementById('phone').value = contact.phone;
  document.getElementById('address').value = contact.address;
  document.getElementById('category').value = contact.category;
  document.getElementById('save-button').textContent = 'Update Contact';
}

function showStatus(message, success = true) {
  formStatus.textContent = message;
  formStatus.style.color = success ? 'var(--text-muted)' : 'var(--danger)';
}

contactForm.addEventListener('submit', event => {
  event.preventDefault();
  const formData = new FormData(contactForm);
  const newContact = {
    id: editingId || createId(),
    name: formData.get('name').trim(),
    email: formData.get('email').trim(),
    phone: formData.get('phone').trim(),
    address: formData.get('address').trim(),
    category: formData.get('category') || 'other',
  };

  if (!newContact.name || !newContact.email || !newContact.phone) {
    showStatus('Name, email, and phone are required.', false);
    return;
  }

  if (editingId) {
    contacts = contacts.map(contact => (contact.id === editingId ? newContact : contact));
    showStatus('Contact updated successfully.');
  } else {
    contacts.push(newContact);
    showStatus('Contact saved successfully.');
  }

  saveContacts();
  resetForm();
  renderContacts();
});

contactForm.addEventListener('reset', () => {
  setTimeout(() => {
    showStatus('Form reset. Enter a new contact to save.');
    resetForm();
  }, 0);
});

contactList.addEventListener('click', event => {
  const button = event.target.closest('button');
  if (!button) return;

  const contactId = button.dataset.id;
  const contact = contacts.find(item => item.id === contactId);
  if (!contact) return;

  if (button.classList.contains('edit')) {
    editingId = contactId;
    populateForm(contact);
    showStatus('Editing contact. Update the fields and submit.', true);
  }

  if (button.classList.contains('delete')) {
    contacts = contacts.filter(item => item.id !== contactId);
    saveContacts();
    renderContacts();
    showStatus('Contact removed from the address book.', true);
  }
});

searchInput.addEventListener('input', renderContacts);
filterCategory.addEventListener('change', renderContacts);

clearStorageButton.addEventListener('click', () => {
  if (!confirm('Clear all contacts from Local Storage?')) return;
  contacts = [];
  saveContacts();
  renderContacts();
  showStatus('All contacts cleared from storage.');
});

exportJsonButton.addEventListener('click', () => {
  const json = JSON.stringify(contacts, null, 2);
  const blob = new Blob([json], { type: 'application/json' });
  const url = URL.createObjectURL(blob);
  const link = document.createElement('a');
  link.href = url;
  link.download = 'address-book.json';
  document.body.appendChild(link);
  link.click();
  link.remove();
  URL.revokeObjectURL(url);
  showStatus('Contacts exported as JSON.');
});

importJsonButton.addEventListener('click', async () => {
  const fileInput = document.createElement('input');
  fileInput.type = 'file';
  fileInput.accept = 'application/json';

  fileInput.addEventListener('change', async () => {
    const file = fileInput.files?.[0];
    if (!file) return;

    try {
      const text = await file.text();
      const parsed = JSON.parse(text);
      if (!Array.isArray(parsed)) throw new Error('Invalid format');
      const importedContacts = parsed
        .filter(item => item.name && item.email && item.phone)
        .map(item => ({
          id: item.id || createId(),
          name: String(item.name),
          email: String(item.email),
          phone: String(item.phone),
          address: String(item.address || ''),
          category: String(item.category || 'other'),
        }));

      contacts = [...contacts, ...importedContacts];
      saveContacts();
      renderContacts();
      showStatus('JSON imported and merged into the address book.');
    } catch (error) {
      showStatus('Failed to import JSON. Please use a valid address book file.', false);
    }
  });

  fileInput.click();
});

function initialize() {
  contacts = loadContacts();
  renderContacts();
}

initialize();
