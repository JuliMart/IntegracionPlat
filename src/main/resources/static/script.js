async function obtenerClientes() {
    try {
        const response = await fetch('http://localhost:8080/cliente/clientes'); // URL de la API de clientes
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }
        const clientes = await response.json();
        displayClientes(clientes);
    } catch (error) {
        console.error('There has been a problem with your fetch operation:', error);
    }
}

function displayClientes(clientes) {
    const tbody = document.getElementById('clientes-table').getElementsByTagName('tbody')[0];
    tbody.innerHTML = ''; // Clear existing rows

    clientes.forEach(cliente => {
        const row = tbody.insertRow();
        const cellId = row.insertCell(0);
        const cellNombre = row.insertCell(1);
        const cellApellido = row.insertCell(2);
        const cellEmail = row.insertCell(3);

        cellId.textContent = cliente.id;
        cellNombre.textContent = cliente.nombre;
        cellApellido.textContent = cliente.apellido;
        cellEmail.textContent = cliente.email;
    });
}

async function obtenerProductos() {
    try {
        const response = await fetch('http://localhost:8080/producto/productos'); // URL de la API de productos
        if (!response.ok) {
            throw new Error('Algo no está bien.. ' + response.statusText);
        }
        const productos = await response.json();
        displayProductos(productos);
    } catch (error) {
        console.error('Hay algún tipo de problema:', error);
    }
}

function displayProductos(productos) {
    const tbody = document.getElementById('productos-table').getElementsByTagName('tbody')[0];
    tbody.innerHTML = ''; // Clear existing rows

    productos.forEach(producto => {
        const row = tbody.insertRow();
        const cellId = row.insertCell(0);
        const cellArticulo = row.insertCell(1);
        const cellDescripcion = row.insertCell(2);
        const cellMarca = row.insertCell(3);

        cellId.textContent = producto.id;
        cellArticulo.textContent = producto.articulo;
        cellDescripcion.textContent = producto.descripcion;
        cellMarca.textContent = producto.marca;
    });
}

async function obtenerDeliverys() {
    try {
        const response = await fetch('http://localhost:8080/delivery/deliverys'); // URL de la API de deliverys
        if (!response.ok) {
            throw new Error('Algo no está bien.. ' + response.statusText);
        }
        const deliverys = await response.json();
        displayDeliverys(deliverys);
    } catch (error) {
        console.error('Hay algún tipo de problema:', error);
    }
}

function displayDeliverys(deliverys) {
    const tbody = document.getElementById('deliverys-table').getElementsByTagName('tbody')[0];
    tbody.innerHTML = ''; // Clear existing rows

    deliverys.forEach(delivery => {
        const row = tbody.insertRow();
        const cellId = row.insertCell(0);
        const cellDireccion = row.insertCell(1);
        const cellComuna = row.insertCell(2);
        const cellRegion = row.insertCell(3);

        cellId.textContent = delivery.id;
        cellDireccion.textContent = delivery.direccion;
        cellComuna.textContent = delivery.comuna;
        cellRegion.textContent = delivery.region;
    });
}
