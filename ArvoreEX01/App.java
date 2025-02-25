public class App {
    public static void main(String[] args) throws Exception {
        Arvore escola = new Arvore();
        escola.inserir(null, new Aluno(5, "Roger", "SI"));
        escola.inserir(escola.raiz, new Aluno(2, "Daniel", "SI"));
        escola.inserir(escola.raiz, new Aluno(7, "Ana", "SI"));
        escola.inserir(escola.raiz, new Aluno(1, "Marselo", "SI"));
        escola.inserir(escola.raiz, new Aluno(3, "Clark", "SI"));
        escola.inserir(escola.raiz, new Aluno(6, "Diego", "SI"));
        escola.inserir(escola.raiz, new Aluno(8, "Pedro", "SI"));
        escola.inserir(escola.raiz, new Aluno(4, "Miguel", "SI"));
        escola.inserir(escola.raiz, new Aluno(9, "Matheus", "SI"));
        escola.inserir(escola.raiz, new Aluno(0, "Laura", "SI"));
        System.out.println("----------------- Pré-Ordem -----------------");
        escola.preOrdem(escola.raiz);
        System.out.println("---------------------------------------------");
        Aluno temp = escola.excluir(8);
        System.out.printf("Aluno: '%d - %s' excluído com sucesso.\n", temp.matricula, temp.nome);
        System.out.println("----------------- Pré-Ordem -----------------");
        escola.preOrdem(escola.raiz);
        System.out.println("---------------------------------------------");
        temp = escola.maximo(escola.raiz);
        System.out.printf("O aluno(a) com maior matrícula é '%d - %s'\n", temp.matricula, temp.nome);
        System.out.println("---------------------------------------------");
        int matricula = 10;
        if (escola.existeAluno(escola.raiz, matricula)) {
            System.out.printf("Há um aluno com matrícula %d\n", matricula);
        } else {
            System.out.printf("Não há um aluno com matrícula %d\n", matricula);
        }
        System.out.println("---------------------------------------------");
        matricula = 2;
        if (escola.existeAluno(escola.raiz, matricula)) {
            System.out.printf("Há um aluno com matrícula: %d\n", matricula);
        } else {
            System.out.printf("Não há um aluno com matrícula: %d\n", matricula);
        }
        System.out.println("---------------------------------------------");
    }
}
