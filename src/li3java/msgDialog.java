package li3java;

import javax.swing.JOptionPane;

public class msgDialog {
    // inserido user
    public static final String utilizador_novo_sucesso_msg = "Utilizador adicionado!";
    public static final String utilizador_novo_sucesso_titulo = "Sucesso";
    public static final int utilizador_novo_sucesso_tipo = JOptionPane.INFORMATION_MESSAGE;
    
    // erro ao inserir user
    public static final String utilizador_novo_insucesso_msg = "Utilizador não inserido\nPode já existir um utilizador com o mesmo Nome ou Número de Contribuinte";
    public static final String utilizador_novo_insucesso_titulo = "Insucesso";
    public static final int utilizador_novo_insucesso_tipo = JOptionPane.WARNING_MESSAGE;
    
    // não foi possível abrir o ficheiro
    public static final String ficheiro_abrir_erro_msg = "Não foi possível abrir o ficheiro.";
    public static final String ficheiro_abrir_erro_titulo = "Insucesso";
    public static final int ficheiro_abrir_erro_tipo = JOptionPane.WARNING_MESSAGE;
}
