// script.js — uses Fetch API (Promise) to call /api/employees
document.addEventListener('DOMContentLoaded', () => {
  const btn = document.getElementById('btnLoad');
  const out = document.getElementById('output');

  btn.addEventListener('click', () => {
    out.innerHTML = 'Loading...';
    // Fetch returns a Promise
    fetch('/api/employees')
      .then(response => {
        if (!response.ok) throw new Error('Network response not ok');
        return response.json();
      })
      .then(list => {
        out.innerHTML = '';
        list.forEach(e => {
          const div = document.createElement('div');
          div.className = 'employee';
          div.textContent = `${e.id}: ${e.name} — ${e.role}`;
          out.appendChild(div);
        });
      })
      .catch(err => {
        out.innerHTML = `<div class="error">Error: ${err.message}</div>`;
      });
  });
});
