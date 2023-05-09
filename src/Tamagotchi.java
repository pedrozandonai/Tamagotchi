// Aluno: Pedro Henrique Zandonai Persch
public class Tamagotchi {
    // Características do Tamagotchi
    private String nome;
    private int idade;
    private int peso;
    private boolean morto;

    // Construtor principal
    public Tamagotchi(String nome, int idade, int peso, boolean morto) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.morto = morto;
    }

    // Métodos de Acesso Get e Set
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

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public boolean getMorto() {
        return morto;
    }

    public void setMorto(boolean morto) {
        this.morto = morto;
    }

    // Método que imprime as informações na tela do jogador
    public void imprimeInformacoes(){
        String nome = "Nome: " + getNome();
        String idade = "Idade: " + getIdade();
        String peso = "Peso: " + getPeso();

        System.out.println();
        System.out.println("+---------------+");
        System.out.println("|   Informações  |");
        System.out.println("+---------------+");
        System.out.println("| " + (nome) + " |");
        System.out.println("| " + (idade) +" |");
        System.out.println("| " + (peso) + " |");
        System.out.println("+---------------+");
        System.out.println();
    }

    // Método de fome do Tamagotchi
    public void fome(){
        System.out.println("Seu Tamagotchi está com fome! selecione alguma dentre as opções abaixo:");
        System.out.println("1 - Comer Pouco");
        System.out.println("2 - Comer Muito");
        System.out.println("3 - Não comer\r\n");

        int opcao = Teclado.leInt("Digite a opção desejada: \r\n");

        if (opcao == 1){
            setPeso(peso+1);
            System.out.println(this.nome + ": Estava uma delícia!");
            System.out.println("Seu Tamagotchi comeu pouco e aumentou 1kg!\r\n");
            imprimeInformacoes();

        }else if(opcao == 2){
            setPeso(peso+5);
            System.out.println(this.nome + ": Nossa! Estou cheio!");
            System.out.println("Seu Tamagotchi comeu um monte e aumentou 5kg!\r\n");
            imprimeInformacoes();
            sono();

        }else if(opcao == 3){
            setPeso(peso-2);
            System.out.println(this.nome+": Tudo bem, posso comer outra hora :(");
            System.out.println("Seu Tamagotchi ficou sem comer e emagreceu 2kg\r\n");
            imprimeInformacoes();


        }else{
            System.out.println("Opção inválida, digite novamente uma opção!\r\n");
        }

        // Verifica se o Tamagotchi morreu
        morte();
    }

    // Variável declarada antes da função para armazenar o valor de quanto tempo o Tamagotchi ficou sem dormir
    int diasSemDormir = 0;

    // Método de sono do Tamagotchi
    public void sono(){
        int maximoDeDiasSemDormir = 5;

        System.out.println("Seu Tamagotchi está com sono! selecione alguma dentre as opções abaixo: ");
        System.out.println("1 - Dormir");
        System.out.println("2 - Permanecer Acordado\r\n");

        int opcao = Teclado.leInt("Digite a opção desejada: \r\n");

        if (opcao == 1){
            setIdade(idade+1);
            System.out.println(this.nome + ": Nossa, a soneca estava maravilhosa!");
            System.out.println("Seu Tamagotchi dormiu e envelheceu 1 dia\r\n");
            imprimeInformacoes();

        }else if (opcao == 2){
            System.out.println(this.nome + ": Tudo bem, fica para a próxima!");
            System.out.println("Seu Tamagotchi ficou sem dormir, caso ele fique mais "+(maximoDeDiasSemDormir-diasSemDormir)+" vezes sem dormir ele irá dormir automaticamente\r\n");
            diasSemDormir += 1;
            imprimeInformacoes();

        }else{
            System.out.println("Opção inválida, digite novamente uma opção!\r\n");
        }

        // Algorítmo que faz o Tamagotchi dormir automaticamente após 5 vezes deixando-o acordado.
        if (diasSemDormir > maximoDeDiasSemDormir){
            diasSemDormir = 0;
            setIdade(idade+1);
            System.out.println(this.nome + ": Nossa, a soneca estava maravilhosa!");
            System.out.println("Seu Tamagotchi dormiu e envelheceu 1 dia\r\n");
            imprimeInformacoes();

        }

        // Verifica se o Tamagotchi morreu
        morte();
    }

    // Cria a ação de entediado do Tamagotchi
    public void entediado(){
        System.out.println("Seu Tamagotchi ficou entediado! selecione alguma dentre as opções abaixo:");
        System.out.println("1 - Correr 10 Minutos");
        System.out.println("2 - Caminhar 10 Minutos\r\n");

        int opcao = Teclado.leInt("Digite a opção desejada: \r\n");

        if (opcao == 1){
            setPeso(peso-4);
            setPeso(peso+5);
            System.out.println(this.nome+": Nossa, me sinto muito fitness!");
            System.out.println("Seu Tamagotchi emagreceu 4kg e ficou com muita fome, então ele decidiu comer muito!\r\n");
            imprimeInformacoes();


        }else if(opcao == 2){
            setPeso(peso-1);
            System.out.println(this.nome+": Adorei a caminhada com você!");
            System.out.println("Seu Tamagotchi emagreceu 1kg e está com fome!\r\n");
            imprimeInformacoes();
            fome();

            }else{
            System.out.println("Opção inválida, digite novamente uma opção!\r\n");
        }

        // Verifica se o Tamagotchi morreu
        morte();
    }

    // Verifica os atributos do Tamagotchi para ver se ele continua vivo ou morto
    public void morte(){
        if (peso >= 20) {
            setMorto(true);

            System.out.println(getNome()+": Foi ótimo dividir essa aventura com você!");
            System.out.println("Seu Tamagotchi comeu tanto que explodiu e morreu! Obrigado por jogar!\r\n");
            imprimeInformacoes();

        } else if (peso <= 0) {
            setMorto(true);

            System.out.println(getNome()+": Foi ótimo dividir essa aventura com você!");
            System.out.println("Seu Tamagotchi ficou desnutrido e morreu! Obrigado por jogar!\r\n");
            imprimeInformacoes();
            
        } else if (idade >= 15) {
            setMorto(true);

            System.out.println(getNome()+": Foi ótimo dividir essa aventura com você!");
            System.out.println("Seu Tamagotchi ficou velhinho e morreu! Obrigado por jogar!\r\n");
            imprimeInformacoes();
        }
    }
}