public class Condutor {
    private String nome;
    private String cnh;
    
    public Condutor(String nome, String cnh) {
        this.nome = nome;
        this.cnh = cnh;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    @Override
    public String toString() {
        return "Nome do condutor: " + nome + 
               "\nCNH do condutor: " + cnh;
    }
}
