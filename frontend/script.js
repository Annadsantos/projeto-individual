const API_URL = 'http://localhost:8080';
document.addEventListener('DOMContentLoaded', function() {
    carregarPaises();
});

function carregarPaises() {
    fetch(`${API_URL}/paises`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro ao buscar países: " + response.status);
            }
            return response.json();
        })
        .then(paises => {
            const selectPais = document.getElementById("select-pais");
            selectPais.innerHTML = '<option value="">Selecione o seu país...</option>';

            paises.forEach(item => {
                const option = document.createElement('option');
                const valor = item.nome || item;
                option.value = valor;
                option.textContent = valor;
                selectPais.appendChild(option);
            });
        })
        .catch(error => console.error('Falha na requisição dos países:', error));
}

function enviarTriagem(dadosTriagem) {
    fetch(`${API_URL}/triagens`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dadosTriagem)
    })
    .then(async response => {
        if (response.status == 201) {
            window.location.href = 'resultado.html';
        } else {
            const mensagem = await response.text();
            alert('Erro ao salvar: ' + mensagem);
        }
    })
    .catch(error => console.error('Falha no envio da triagem:', error));
}