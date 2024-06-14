document.getElementById('login-form').addEventListener('submit', async function(event) {
    event.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    try {
        const response = await fetch('http://localhost:8080/authenticate', { // Reemplaza con la URL de tu API de autenticación
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ username, password })
        });

        if (!response.ok) {
            throw new Error('Credenciales incorrectas');
        }

        const result = await response.json();
        localStorage.setItem('authToken', result.token); // Guarda el token de autenticación
        window.location.href = 'index.html'; // Redirige a la página principal
    } catch (error) {
        alert(error.message);
    }
});
