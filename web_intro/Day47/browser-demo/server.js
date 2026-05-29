// server.js — simple static file server + /api/employees endpoint
const http = require('http');
const fs = require('fs');
const path = require('path');

const port = process.env.PORT || 3000;

const employees = [
  { id: 1, name: 'Alice', role: 'Engineer' },
  { id: 2, name: 'Bob', role: 'Designer' },
  { id: 3, name: 'Charlie', role: 'Manager' }
];

function sendJSON(res, obj) {
  const body = JSON.stringify(obj);
  res.writeHead(200, { 'Content-Type': 'application/json', 'Content-Length': Buffer.byteLength(body) });
  res.end(body);
}

function serveStatic(req, res) {
  let filePath = req.url === '/' ? '/index.html' : req.url;
  filePath = path.join(__dirname, filePath);

  fs.readFile(filePath, (err, data) => {
    if (err) {
      res.writeHead(404);
      return res.end('Not found');
    }
    const ext = path.extname(filePath).toLowerCase();
    const map = { '.html': 'text/html', '.css': 'text/css', '.js': 'application/javascript' };
    const ct = map[ext] || 'application/octet-stream';
    res.writeHead(200, { 'Content-Type': ct });
    res.end(data);
  });
}

const server = http.createServer((req, res) => {
  if (req.url === '/api/employees') {
    // simulate async delay
    setTimeout(() => sendJSON(res, employees), 400);
    return;
  }

  // allow simple static files under this folder
  serveStatic(req, res);
});

server.listen(port, () => console.log(`Server running at http://localhost:${port}/`));
