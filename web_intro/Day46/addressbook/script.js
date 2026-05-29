// Address Book App
class AddressBook {
    constructor() {
        this.contacts = this.loadFromLocalStorage();
        this.currentEditId = null;
        this.initializeEventListeners();
        this.displayContacts();
    }

    // Load contacts from localStorage
    loadFromLocalStorage() {
        const data = localStorage.getItem('contacts');
        return data ? JSON.parse(data) : [];
    }

    // Save contacts to localStorage
    saveToLocalStorage() {
        localStorage.setItem('contacts', JSON.stringify(this.contacts));
    }

    // Generate unique ID
    generateId() {
        return '_' + Math.random().toString(36).substr(2, 9);
    }

    // Initialize Event Listeners
    initializeEventListeners() {
        // Form submission
        document.getElementById('contactForm').addEventListener('submit', (e) => {
            e.preventDefault();
            this.addContact();
        });

        // Search functionality
        document.getElementById('searchInput').addEventListener('input', (e) => {
            this.filterContacts();
        });

        // Category filter
        document.getElementById('categoryFilter').addEventListener('change', (e) => {
            this.filterContacts();
        });

        // Contact Modal controls
        const contactModal = document.getElementById('contactModal');
        const closeButtons = document.querySelectorAll('.close');

        closeButtons.forEach(btn => {
            btn.addEventListener('click', (e) => {
                if (e.target.closest('#contactModal')) {
                    contactModal.style.display = 'none';
                }
            });
        });

        window.addEventListener('click', (e) => {
            if (e.target === contactModal) {
                contactModal.style.display = 'none';
            }
        });

        // Edit Modal
        const editModal = document.getElementById('editModal');
        document.getElementById('editForm').addEventListener('submit', (e) => {
            e.preventDefault();
            this.updateContact();
        });

        document.querySelectorAll('.cancel-btn').forEach(btn => {
            btn.addEventListener('click', () => {
                editModal.style.display = 'none';
            });
        });

        window.addEventListener('click', (e) => {
            if (e.target === editModal) {
                editModal.style.display = 'none';
            }
        });
    }

    // Add Contact (CREATE)
    addContact() {
        const firstName = document.getElementById('firstName').value.trim();
        const lastName = document.getElementById('lastName').value.trim();
        const email = document.getElementById('email').value.trim();
        const phone = document.getElementById('phone').value.trim();
        const category = document.getElementById('category').value;
        const address = document.getElementById('address').value.trim();
        const city = document.getElementById('city').value.trim();
        const state = document.getElementById('state').value.trim();
        const zipCode = document.getElementById('zipCode').value.trim();

        // Validate
        if (!firstName || !lastName || !email || !phone || !address || !city || !state || !zipCode) {
            alert('Please fill all required fields!');
            return;
        }

        // Validate email format
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailRegex.test(email)) {
            alert('Please enter a valid email address!');
            return;
        }

        // Create contact object
        const contact = {
            id: this.generateId(),
            firstName,
            lastName,
            email,
            phone,
            category,
            address,
            city,
            state,
            zipCode,
            createdAt: new Date().toISOString()
        };

        this.contacts.push(contact);
        this.saveToLocalStorage();
        this.displayContacts();
        document.getElementById('contactForm').reset();
        alert('Contact added successfully!');
    }

    // Display Contacts (READ)
    displayContacts(contactsToDisplay = null) {
        const grid = document.getElementById('contactsGrid');
        const data = contactsToDisplay || this.contacts;

        if (data.length === 0) {
            grid.innerHTML = `
                <div class="no-contacts">
                    <i class="fas fa-inbox"></i>
                    <p>No contacts found. Add your first contact!</p>
                </div>
            `;
            return;
        }

        grid.innerHTML = data.map(contact => `
            <div class="contact-card">
                <div class="contact-card-content">
                    <div class="contact-name">
                        <i class="fas fa-user-circle"></i>
                        ${contact.firstName} ${contact.lastName}
                        <span class="category-badge">${contact.category}</span>
                    </div>
                    <div class="contact-info">
                        <div><i class="fas fa-envelope"></i>${contact.email}</div>
                        <div><i class="fas fa-phone"></i>${contact.phone}</div>
                        <div><i class="fas fa-map-marker-alt"></i>${contact.city}, ${contact.state}</div>
                    </div>
                    <div class="card-actions">
                        <button class="view-btn" onclick="app.viewContact('${contact.id}')">
                            <i class="fas fa-eye"></i> View
                        </button>
                        <button class="edit-btn" onclick="app.openEditModal('${contact.id}')">
                            <i class="fas fa-edit"></i> Edit
                        </button>
                        <button class="delete-btn" onclick="app.deleteContact('${contact.id}')">
                            <i class="fas fa-trash"></i> Delete
                        </button>
                    </div>
                </div>
            </div>
        `).join('');
    }

    // View Contact Details
    viewContact(id) {
        const contact = this.contacts.find(c => c.id === id);
        if (!contact) return;

        const modalBody = document.getElementById('modalBody');
        modalBody.innerHTML = `
            <div class="contact-details">
                <h3><i class="fas fa-user-circle"></i> ${contact.firstName} ${contact.lastName}</h3>
                <div class="detail-item">
                    <span class="detail-label"><i class="fas fa-tag"></i> Category</span>
                    <span class="detail-value">${contact.category}</span>
                </div>
                <div class="detail-item">
                    <span class="detail-label"><i class="fas fa-envelope"></i> Email</span>
                    <span class="detail-value">${contact.email}</span>
                </div>
                <div class="detail-item">
                    <span class="detail-label"><i class="fas fa-phone"></i> Phone</span>
                    <span class="detail-value">${contact.phone}</span>
                </div>
                <div class="detail-item">
                    <span class="detail-label"><i class="fas fa-home"></i> Address</span>
                    <span class="detail-value">${contact.address}</span>
                </div>
                <div class="detail-item">
                    <span class="detail-label"><i class="fas fa-city"></i> City/State/Zip</span>
                    <span class="detail-value">${contact.city}, ${contact.state} ${contact.zipCode}</span>
                </div>
            </div>
        `;

        document.getElementById('contactModal').style.display = 'block';
    }

    // Update Contact (UPDATE)
    openEditModal(id) {
        const contact = this.contacts.find(c => c.id === id);
        if (!contact) return;

        this.currentEditId = id;

        // Populate edit form
        document.getElementById('editFirstName').value = contact.firstName;
        document.getElementById('editLastName').value = contact.lastName;
        document.getElementById('editEmail').value = contact.email;
        document.getElementById('editPhone').value = contact.phone;
        document.getElementById('editCategory').value = contact.category;
        document.getElementById('editAddress').value = contact.address;
        document.getElementById('editCity').value = contact.city;
        document.getElementById('editState').value = contact.state;
        document.getElementById('editZipCode').value = contact.zipCode;

        document.getElementById('editModal').style.display = 'block';
    }

    updateContact() {
        const contact = this.contacts.find(c => c.id === this.currentEditId);
        if (!contact) return;

        contact.firstName = document.getElementById('editFirstName').value.trim();
        contact.lastName = document.getElementById('editLastName').value.trim();
        contact.email = document.getElementById('editEmail').value.trim();
        contact.phone = document.getElementById('editPhone').value.trim();
        contact.category = document.getElementById('editCategory').value;
        contact.address = document.getElementById('editAddress').value.trim();
        contact.city = document.getElementById('editCity').value.trim();
        contact.state = document.getElementById('editState').value.trim();
        contact.zipCode = document.getElementById('editZipCode').value.trim();

        this.saveToLocalStorage();
        this.displayContacts();
        document.getElementById('editModal').style.display = 'none';
        alert('Contact updated successfully!');
    }

    // Delete Contact (DELETE)
    deleteContact(id) {
        if (confirm('Are you sure you want to delete this contact?')) {
            this.contacts = this.contacts.filter(c => c.id !== id);
            this.saveToLocalStorage();
            this.displayContacts();
            alert('Contact deleted successfully!');
        }
    }

    // Filter and Search Contacts
    filterContacts() {
        const searchQuery = document.getElementById('searchInput').value.toLowerCase();
        const categoryFilter = document.getElementById('categoryFilter').value;

        const filtered = this.contacts.filter(contact => {
            const matchesSearch = contact.firstName.toLowerCase().includes(searchQuery) ||
                                  contact.lastName.toLowerCase().includes(searchQuery) ||
                                  contact.email.toLowerCase().includes(searchQuery) ||
                                  contact.phone.includes(searchQuery);

            const matchesCategory = categoryFilter === '' || contact.category === categoryFilter;

            return matchesSearch && matchesCategory;
        });

        this.displayContacts(filtered);
    }
}

// Initialize app when DOM is loaded
let app;
document.addEventListener('DOMContentLoaded', () => {
    app = new AddressBook();
});
