public class Aluno {
  public int matricula;
  public String nome;
  public String curso;
  public Aluno esquerda;
  public Aluno direita;

  public Aluno(int matricula, String nome, String curso) {
    this.matricula = matricula;
    this.nome = nome;
    this.curso = curso;
    this.esquerda = null;
    this.direita = null;
  }

  @Override
  public String toString() {
    return "[ Matrícula : " + this.matricula + " | Nome: " + this.nome + " | Curso: " + this.curso + " ]";
  }
}