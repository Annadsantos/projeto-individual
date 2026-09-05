document.getElementById('form-cadastro').onsubmit = function(event) {
    event.preventDefault();

    var nome = document.getElementById('nome').value.trim();
    if (nome == '' || nome.length < 2) {
        alert('Digite um nome válido.');
        return;
    }

    var idade = document.getElementById('idade').value;
    if (idade == '' || idade < 0 || idade > 120) {
        alert('Digite uma idade válida (0 a 120).');
        return;
    }

    var nascimento = document.getElementById('nascimento').value;
    if (nascimento == '') {
        alert('Selecione sua data de nascimento.');
        return;
    }

    var dorSelecionada = document.querySelector('input[name="sente_dor"]:checked');
    if (!dorSelecionada) {
        alert('Selecione uma das opções de dor.');
        return;
    }

    var sintomasElementos = document.querySelectorAll('input[name="sintomas"]:checked');
    if (sintomasElementos.length == 0) {
        alert('Marque ao menos um sintoma (ou nenhum).');
        return;
    }

    var sintomasTexto = '';
    for (var i = 0; i < sintomasElementos.length; i++) {
        if (i > 0) {
            sintomasTexto += ', ';
        }
        sintomasTexto += sintomasElementos[i].value;
    }

    var pais = document.getElementById('select-pais').value;
    if (pais == '') {
        alert('Selecione o seu país.');
        return;
    }

    var dadosTriagem = {
        nome: nome,
        idade: parseInt(idade),
        dataNascimento: nascimento,
        senteDor: dorSelecionada.value,
        sintomas: sintomasTexto,
        pais: pais
    };

    enviarTriagem(dadosTriagem);
};