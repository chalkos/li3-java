package li3java;

import javax.swing.JOptionPane;

public class msgDialog {
    // inserido user
    public static final String utilizador_novo_sucesso_msg = "Utilizador adicionado!";
    public static final String utilizador_novo_sucesso_titulo = "Sucesso";
    public static final int utilizador_novo_sucesso_tipo = JOptionPane.INFORMATION_MESSAGE;
    
    // erro ao inserir user
    public static final String utilizador_novo_insucesso_msg = "Utilizador não inserido\nPode já existir um utilizador com o mesmo Nome ou Número de Contribuinte.";
    public static final String utilizador_novo_insucesso_titulo = "Erro ao inserir Utilizador";
    public static final int utilizador_novo_insucesso_tipo = JOptionPane.WARNING_MESSAGE;
    
    // inserido user
    public static final String localidade_novo_sucesso_msg = "Localidade adicionada!";
    public static final String localidade_novo_sucesso_titulo = "Sucesso";
    public static final int localidade_novo_sucesso_tipo = JOptionPane.INFORMATION_MESSAGE;
    
    // erro ao inserir user
    public static final String localidade_novo_insucesso_msg = "Localidade não inserida\nPode já existir uma localidade com o mesmo Nome.";
    public static final String localidade_novo_insucesso_titulo = "Erro ao inserir Localidade";
    public static final int localidade_novo_insucesso_tipo = JOptionPane.WARNING_MESSAGE;
    
    // não foi possível abrir o ficheiro
    public static final String ficheiro_abrir_erro_msg = "Não foi possível abrir o ficheiro.";
    public static final String ficheiro_abrir_erro_titulo = "Insucesso";
    public static final int ficheiro_abrir_erro_tipo = JOptionPane.ERROR_MESSAGE;
    
    // conversão de string para double falhou
    public static final String stringToDouble_msg = "Deve introduzir um número real";
    public static final String stringToDouble_titulo = "Erro de Valor";
    public static final int stringToDouble_tipo = JOptionPane.WARNING_MESSAGE;
    
    // não introduziu origem e/ou destino
    public static final String seleccioneOrigemEDestino_msg = "Deve seleccionar uma origem e\num destino.";
    public static final String seleccioneOrigemEDestino_titulo = "Dados insuficientes";
    public static final int seleccioneOrigemEDestino_tipo = JOptionPane.WARNING_MESSAGE;
    
    // seleccionou a mesma origem e destino
    public static final String origemEDestinoIguais_msg = "A origem e destino devem ser localidades diferentes.";
    public static final String origemEDestinoIguais_titulo = "Dados inválidos";
    public static final int origemEDestinoIguais_tipo = JOptionPane.WARNING_MESSAGE;
    
    // inserir ligação: sucesso
    public static final String sucessoInserirLigacao_msg = "Ligação criada!";
    public static final String sucessoInserirLigacao_titulo = "Sucesso";
    public static final int sucessoInserirLigacao_tipo = JOptionPane.INFORMATION_MESSAGE;
    
    // ficheiro criado com sucesso
    public static final String sucessoEscreverDados_msg = "Dados guardados!";
    public static final String sucessoEscreverDados_titulo = "Sucesso";
    public static final int sucessoEscreverDados_tipo = JOptionPane.INFORMATION_MESSAGE;
    
    // não foi possível guardar os dados
    public static final String insucessoEscreverDados_msg = "Não foi possível guardar os dados.";
    public static final String insucessoEscreverDados_titulo = "Erro ao guardar dados";
    public static final int insucessoEscreverDados_tipo = JOptionPane.ERROR_MESSAGE;
    
    // inserir ligação: sucesso
    public static final String insucessoInserirLigacao_msg = "Ligação já existe.";
    public static final String insucessoInserirLigacao_titulo = "Erro ao criar Ligação";
    public static final int insucessoInserirLigacao_tipo = JOptionPane.WARNING_MESSAGE;
    
    // abrir ficheiro EF, ficheiro corrompido
    public static final String EF_corrompido_msg = "Ficheiro corrompido, não é possível importar";
    public static final String EF_corrompido_titulo = "Ficheiro corrompido";
    public static final int EF_corrompido_tipo = JOptionPane.ERROR_MESSAGE;
    
    // ficheiro já existe, substituir?
    public static final String ficheiroExiste_msg = "Ficheiro existe, substituir?";
    public static final String ficheiroExiste_titulo = "Ficheiro já existe";
    
    
}
