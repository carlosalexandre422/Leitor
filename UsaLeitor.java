import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Random;
class Pessoa{
    private String nome;
    private int idade;
    private String sexo;

    public Pessoa(String nome, int idade, String sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void fazeAniver(){
        setIdade(getIdade()+1);
    }
}

class Livro implements Publicacao{

    Random aleatorio = new Random();
    private String titulo;
    private String autor;
    private int totPaginas;
    private int pagAtual;
    private boolean aberto;
    private Pessoa leitor;

    public Livro(String titulo, String autor, int totPaginas, Pessoa leitor) {
        this.titulo = titulo;
        this.autor = autor;
        this.totPaginas = totPaginas;
        this.leitor = leitor;
        this.aberto = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getTotPaginas() {
        return totPaginas;
    }

    public void setTotPaginas(int totPaginas) {
        this.totPaginas = totPaginas;
    }

    public int getPagAtual() {
        return pagAtual;
    }

    public void setPagAtual(int pagAtual) {
        this.pagAtual = pagAtual;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public Pessoa getLeitor() {
        return leitor;
    }

    public void setLeitor(Pessoa leitor) {
        this.leitor = leitor;
    }

    public void detalhes(){
        System.out.println("### DETALHES DO LIVRO ###");
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Total de Páginas: " + getTotPaginas());
        System.out.println("Página Atual: " + getPagAtual());
        System.out.println("Está aberto?: " + isAberto());
        System.out.println("Leitor: " + getLeitor().getNome());
    }

    @Override
    public void abrir() {
        if(!isAberto()){
            setAberto(true);
            setPagAtual(0);//pagina 0 é a capa
        }
    }

    @Override
    public void fechar() {
        if(isAberto()){
            setAberto(false);
        }
    }

    @Override
    public void folhear() {
        if(isAberto()){
            int r1 = aleatorio.nextInt(0,getTotPaginas());
            setPagAtual(r1);
        }else{
            System.out.println("Abra o livro antes!");
        }
    }

    @Override
    public void avacarPag() {
        if(isAberto()){
            if(getPagAtual()<getTotPaginas()){
                setPagAtual(getPagAtual()+1);
            }else{
                System.out.println("Já está na última página!");
            }
        }else{
            System.out.println("Abra o livro antes!");
        }
    }

    @Override
    public void voltarPag() {
        if(isAberto()){
            if(getPagAtual()>0){
                setPagAtual(getPagAtual()-1);
            }else{
                System.out.println("Já está na capa!");
            }
        }else{
            System.out.println("Abra o livro antes!");
        }
    }
}

interface Publicacao{
    public abstract void abrir();
    public abstract void fechar();
    public abstract void folhear();
    public abstract void avacarPag();
    public abstract void voltarPag();
}

public class UsaLeitor {
    public static void main(String[] args) {


        Pessoa p1 = new Pessoa("carlos", 34, "s");

        Livro l1 = new Livro("Guerra e Paz", "Tolstoi", 900, p1);

        l1.abrir();
        l1.folhear();
        l1.detalhes();
    }
}
