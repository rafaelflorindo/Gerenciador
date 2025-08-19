import dao.LoginDao;
import model.Login;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormCadastroLogin extends JFrame{
    private JPanel Principal;
    private JTextField TF_Nome;
    private JPasswordField TF_Senha;
    private JTextField TF_Email;
    private JButton cadastrarButton;
    private JButton listarButton;
    private JTable table1;

    LoginDao loginDao;

    //CRIAMOS UM ARRAY DE STRING PARA O RÓTULO DA TABELA
    String[] colunas = {"ID", "NOME", "E-MAIL", "DATA CADASTRO","DATA ATUALIZAÇÃO"};

    //INSERIRINDO O RÓTULO NA LINHA 0 DO OBJETO model
    DefaultTableModel model = new DefaultTableModel(colunas, 0);

    public FormCadastroLogin() {
        setContentPane(Principal);
        table1.setModel(model);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Cadastro de Usuário");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);



        loginDao = new LoginDao();


        loginDao.inserirLogin(new Login("Rafael", "rafael@teste.com", "senha123", "2025-07-01",""));
        loginDao.inserirLogin(new Login("Rafael Silva", "rafael.silva@gmail.com", "Raf@12345", "2025-07-01", ""));
        loginDao.inserirLogin(new Login("Camila Pereira", "camila.pereira@hotmail.com", "Camila!2025", "2025-07-02", ""));
        loginDao.inserirLogin(new Login("Lucas Oliveira", "lucas.oliveira@yahoo.com", "Luca$9876", "2025-07-03", ""));
        loginDao.inserirLogin(new Login("Fernanda Costa", "fernanda.costa@gmail.com", "Fernanda#321", "2025-07-04", ""));
        loginDao.inserirLogin(new Login("Thiago Martins", "thiago.martins@outlook.com", "Thiago@654", "2025-07-05", ""));
        loginDao.inserirLogin(new Login("Aline Rocha", "aline.rocha@gmail.com", "Aline*8520", "2025-07-06", ""));
        loginDao.inserirLogin(new Login("Pedro Almeida", "pedro.almeida@yahoo.com", "Pedro!753", "2025-07-07", ""));
        loginDao.inserirLogin(new Login("Mariana Gomes", "mariana.gomes@hotmail.com", "Mariana#159", "2025-07-08", ""));
        loginDao.inserirLogin(new Login("Felipe Santos", "felipe.santos@gmail.com", "Felipe@456", "2025-07-09", ""));
        loginDao.inserirLogin(new Login("Juliana Ferreira", "juliana.ferreira@outlook.com", "Juliana*789", "2025-07-10", ""));
        loginDao.inserirLogin(new Login("Ricardo Dias", "ricardo.dias@yahoo.com", "Ricardo#963", "2025-07-11", ""));
        loginDao.inserirLogin(new Login("Patrícia Melo", "patricia.melo@gmail.com", "Patricia!852", "2025-07-12", ""));
        loginDao.inserirLogin(new Login("Gustavo Lima", "gustavo.lima@hotmail.com", "Gustavo@147", "2025-07-13", ""));
        loginDao.inserirLogin(new Login("Vanessa Ribeiro", "vanessa.ribeiro@yahoo.com", "Vanessa*258", "2025-07-14", ""));
        loginDao.inserirLogin(new Login("Bruno Castro", "bruno.castro@gmail.com", "Bruno#369", "2025-07-15", ""));
        loginDao.inserirLogin(new Login("Aline Nunes", "aline.nunes@outlook.com", "Aline!741", "2025-07-16", ""));
        loginDao.inserirLogin(new Login("Eduardo Moreira", "eduardo.moreira@yahoo.com", "Eduardo@852", "2025-07-17", ""));
        loginDao.inserirLogin(new Login("Larissa Fernandes", "larissa.fernandes@gmail.com", "Larissa*963", "2025-07-18", ""));
        loginDao.inserirLogin(new Login("Caio Souza", "caio.souza@hotmail.com", "Caio#159", "2025-07-19", ""));
        loginDao.inserirLogin(new Login("Sofia Barbosa", "sofia.barbosa@yahoo.com", "Sofia!357", "2025-07-20", ""));



        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = TF_Nome.getText();
                String email = TF_Email.getText();
                String senha = TF_Senha.getText();

                String dataCadastro = "2025-08-14" ;
                String dataAtualizacao= "";

                Login login = new Login(nome, email, senha, dataCadastro, dataAtualizacao);
                if(loginDao.inserirLogin(login)){
                    JOptionPane.showMessageDialog(null,
                            "Usuário cadastrado com sucesso.");
                }else{
                    JOptionPane.showMessageDialog(null,
                            "Erro ao cadastrar o usuário.");
                }
            }
        });
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(loginDao.getLista());

                model.setRowCount(0);
                for(Login l : loginDao.getLista()){
                    Object[] linha = {
                            l.getId(),
                            l.getNome(),
                            l.getEmail(),
                            l.getDataCadastro(),
                            l.getDataAtualizacao()
                    };
                    model.addRow(linha);
                }
            }
        });
    }
}
