function mostrarSeccion(seccionId) {
    const secciones = document.querySelectorAll('.container');
    secciones.forEach(seccion => {
        seccion.style.display = 'none';
    });
    document.getElementById(seccionId).style.display = 'block';
}

function redirigirALogin() {
    window.location.href = '/login.html'; // Cambia esta URL por la URL de tu página de login
}

// Manejo de Clientes
document.getElementById('cliente-form').addEventListener('submit', async function (event) {
    event.preventDefault();
    const nombre = document.getElementById('cliente-nombre').value;
    const apellido = document.getElementById('cliente-apellido').value;
    const email = document.getElementById('cliente-email').value;

    await agregarCliente({ nombre, apellido, email });
    obtenerClientes();
});

async function agregarCliente(cliente) {
    try {
        const response = await fetch('http://localhost:8080/cliente/guardar', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(cliente)
        });
        if (!response.ok) {
            throw new Error('Error al agregar cliente');
        }
    } catch (error) {
        console.error('Error:', error);
    }
}

async function obtenerClientes() {
    try {
        const response = await fetch('http://localhost:8080/cliente/clientes');
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
    tbody.innerHTML = '';

    clientes.forEach(cliente => {
        const row = tbody.insertRow();
        const cellId = row.insertCell(0);
        const cellNombre = row.insertCell(1);
        const cellApellido = row.insertCell(2);
        const cellEmail = row.insertCell(3);
        const cellAcciones = row.insertCell(4);

        cellId.textContent = cliente.id;
        cellNombre.textContent = cliente.nombre;
        cellApellido.textContent = cliente.apellido;
        cellEmail.textContent = cliente.email;

        const btnEliminar = document.createElement('button');
        btnEliminar.textContent = 'Eliminar';
        btnEliminar.onclick = () => eliminarCliente(cliente.id);

        const btnActualizar = document.createElement('button');
        btnActualizar.textContent = 'Actualizar';
        btnActualizar.onclick = () => actualizarCliente(cliente);

        cellAcciones.appendChild(btnEliminar);
        cellAcciones.appendChild(btnActualizar);
    });
}

async function eliminarCliente(id) {
    try {
        const response = await fetch(`http://localhost:8080/cliente/cliente/${id}`, {
            method: 'DELETE'
        });
        if (!response.ok) {
            throw new Error('Error al eliminar cliente');
        }
        obtenerClientes();
    } catch (error) {
        console.error('Error:', error);
    }
}

async function actualizarCliente(cliente) {
    const nombre = prompt("Actualizar nombre", cliente.nombre);
    const apellido = prompt("Actualizar apellido", cliente.apellido);
    const email = prompt("Actualizar email", cliente.email);

    if (nombre && apellido && email) {
        try {
            const response = await fetch(`http://localhost:8080/cliente/cliente/${cliente.id}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ nombre, apellido, email })
            });
            if (!response.ok) {
                throw new Error('Error al actualizar cliente');
            }
            obtenerClientes();
        } catch (error) {
            console.error('Error:', error);
        }
    }
}

// Manejo de Productos
document.getElementById('producto-form').addEventListener('submit', async function (event) {
    event.preventDefault();
    const articulo = document.getElementById('producto-articulo').value;
    const descripcion = document.getElementById('producto-descripcion').value;
    const marca = document.getElementById('producto-marca').value;

    await agregarProducto({ articulo, descripcion, marca });
    obtenerProductos();
});

async function agregarProducto(producto) {
    try {
        const response = await fetch('http://localhost:8080/producto/guardar', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(producto)
        });
        if (!response.ok) {
            throw new Error('Error al agregar producto');
        }
    } catch (error) {
        console.error('Error:', error);
    }
}

async function obtenerProductos() {
    try {
        const response = await fetch('http://localhost:8080/producto/productos');
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }
        const productos = await response.json();
        displayProductos(productos);
    } catch (error) {
        console.error('There has been a problem with your fetch operation:', error);
    }
}

function displayProductos(productos) {
    const tbody = document.getElementById('productos-table').getElementsByTagName('tbody')[0];
    tbody.innerHTML = '';

    productos.forEach(producto => {
        const row = tbody.insertRow();
        const cellId = row.insertCell(0);
        const cellArticulo = row.insertCell(1);
        const cellDescripcion = row.insertCell(2);
        const cellMarca = row.insertCell(3);
        const cellAcciones = row.insertCell(4);

        cellId.textContent = producto.id;
        cellArticulo.textContent = producto.articulo;
        cellDescripcion.textContent = producto.descripcion;
        cellMarca.textContent = producto.marca;

        const btnEliminar = document.createElement('button');
        btnEliminar.textContent = 'Eliminar';
        btnEliminar.onclick = () => eliminarProducto(producto.id);

        const btnActualizar = document.createElement('button');
        btnActualizar.textContent = 'Actualizar';
        btnActualizar.onclick = () => actualizarProducto(producto);

        cellAcciones.appendChild(btnEliminar);
        cellAcciones.appendChild(btnActualizar);
    });
}

async function eliminarProducto(id) {
    try {
        const response = await fetch(`http://localhost:8080/producto/producto/${id}`, {
            method: 'DELETE'
        });
        if (!response.ok) {
            throw new Error('Error al eliminar producto');
        }
        obtenerProductos();
    } catch (error) {
        console.error('Error:', error);
    }
}

async function actualizarProducto(producto) {
    const articulo = prompt("Actualizar artículo", producto.articulo);
    const descripcion = prompt("Actualizar descripción", producto.descripcion);
    const marca = prompt("Actualizar marca", producto.marca);

    if (articulo && descripcion && marca) {
        try {
            const response = await fetch(`http://localhost:8080/producto/producto/${producto.id}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ articulo, descripcion, marca })
            });
            if (!response.ok) {
                throw new Error('Error al actualizar producto');
            }
            obtenerProductos();
        } catch (error) {
            console.error('Error:', error);
        }
    }
}

// Manejo de Deliverys
document.getElementById('delivery-form').addEventListener('submit', async function (event) {
    event.preventDefault();
    const direccion = document.getElementById('delivery-direccion').value;
    const comuna = document.getElementById('delivery-comuna').value;
    const region = document.getElementById('delivery-region').value;

    await agregarDelivery({ direccion, comuna, region });
    obtenerDeliverys();
});

async function agregarDelivery(delivery) {
    try {
        const response = await fetch('http://localhost:8080/delivery/guardar', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(delivery)
        });
        if (!response.ok) {
            throw new Error('Error al agregar delivery');
        }
    } catch (error) {
        console.error('Error:', error);
    }
}

async function obtenerDeliverys() {
    try {
        const response = await fetch('http://localhost:8080/delivery/deliverys');
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }
        const deliverys = await response.json();
        displayDeliverys(deliverys);
    } catch (error) {
        console.error('There has been a problem with your fetch operation:', error);
    }
}

function displayDeliverys(deliverys) {
    const tbody = document.getElementById('deliverys-table').getElementsByTagName('tbody')[0];
    tbody.innerHTML = '';

    deliverys.forEach(delivery => {
        const row = tbody.insertRow();
        const cellId = row.insertCell(0);
        const cellDireccion = row.insertCell(1);
        const cellComuna = row.insertCell(2);
        const cellRegion = row.insertCell(3);
        const cellAcciones = row.insertCell(4);

        cellId.textContent = delivery.id;
        cellDireccion.textContent = delivery.direccion;
        cellComuna.textContent = delivery.comuna;
        cellRegion.textContent = delivery.region;

        const btnEliminar = document.createElement('button');
        btnEliminar.textContent = 'Eliminar';
        btnEliminar.onclick = () => eliminarDelivery(delivery.id);

        const btnActualizar = document.createElement('button');
        btnActualizar.textContent = 'Actualizar';
        btnActualizar.onclick = () => actualizarDelivery(delivery);

        cellAcciones.appendChild(btnEliminar);
        cellAcciones.appendChild(btnActualizar);
    });
}

async function eliminarDelivery(id) {
    try {
        const response = await fetch(`http://localhost:8080/delivery/delivery/${id}`, {
            method: 'DELETE'
        });
        if (!response.ok) {
            throw new Error('Error al eliminar delivery');
        }
        obtenerDeliverys();
    } catch (error) {
        console.error('Error:', error);
    }
}

async function actualizarDelivery(delivery) {
    const direccion = prompt("Actualizar dirección", delivery.direccion);
    const comuna = prompt("Actualizar comuna", delivery.comuna);
    const region = prompt("Actualizar región", delivery.region);

    if (direccion && comuna && region) {
        try {
            const response = await fetch(`http://localhost:8080/delivery/delivery/${delivery.id}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ direccion, comuna, region })
            });
            if (!response.ok) {
                throw new Error('Error al actualizar delivery');
            }
            obtenerDeliverys();
        } catch (error) {
            console.error('Error:', error);
        }
    }
}

// Obtener y llenar el selector de comunas
async function obtenerComunas() {
    try {
        const response = await fetch('https://apis.modernizacion.cl/dpa/comunas'); // Reemplaza con la URL de tu API de comunas
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }
        const comunas = await response.json();
        const comunaSelect = document.getElementById('delivery-comuna');
        comunas.forEach(comuna => {
            const option = document.createElement('option');
            option.value = comuna.id; // Asume que la comuna tiene un campo id
            option.textContent = comuna.nombre; // Asume que la comuna tiene un campo nombre
            comunaSelect.appendChild(option);
        });
    } catch (error) {
        console.error('There has been a problem with your fetch operation:', error);
    }
}

// Llamar a obtenerComunas cuando se carga la página
document.addEventListener('DOMContentLoaded', obtenerComunas);
