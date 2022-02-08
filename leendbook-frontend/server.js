const express = require('express');
const path = require('path');

const app = express();

// C:\Workspace\lendbooks\leendbook-frontend\dist\leendbook-frontend

// Serve only the static files form the dist directory
app.use(express.static('./dist/leendbook-frontend'));

app.get('/*', (req, res) =>
    res.sendFile('index.html', {root: 'dist/leendbook-frontend/'}),
);

// Start the app by listening on the default Heroku port
app.listen(process.env.PORT || 8080);
