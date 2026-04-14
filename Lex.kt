import kotlin.system.exitProcess

class Lex {

    class Lex (val nome: String) {
        var fome = 50
        var felicidade = 50
        var energia = 50

        fun status() {
            println("\n--- Status do $nome ---")
            println("Fome: $fome")
            println("Felicidade: $felicidade")
            println("Energia: $energia")
        }

        fun comer() {
            println("$nome está comendo ")
            fome -= 15
            energia += 5
        }

        fun brincar() {
            println("$nome está brincando ")
            felicidade += 15
            energia -= 10
            fome += 5
        }

        fun dormir() {
            println("$nome está dormindo ")
            energia += 20
            fome += 10
        }

        fun passarTempo() {
            fome += 5
            felicidade -= 5
            energia -= 5
        }

        fun verificarEstado() {
            if (fome >= 100) {
                println("$nome morreu de fome... ")
                exitProcess(0)
            }
            if (felicidade <= 0) {
                println("$nome ficou triste demais... ")
                exitProcess(0)
            }
            if (energia <= 0) {
                println("$nome morreu de cansaço... ")
                exitProcess(0)
            }
        }
    }

    fun main() {
        println("Digite o nome do seu bichinho:")
        val nome = readLine() ?: "Pet"
        val pet = Lex (nome)

        while (true) {
            pet.status()

            println("\nO que você quer fazer?")
            println("1 - Comer")
            println("2 - Brincar")
            println("3 - Dormir")
            println("4 - Sair")

            when (readLine()) {
                "1" -> pet.comer()
                "2" -> pet.brincar()
                "3" -> pet.dormir()
                "4" -> {
                    println("Saindo do jogo...")
                    break
                }
                else -> println("Opção inválida!")
            }

            pet.passarTempo()
            pet.verificarEstado()
        }
    }
}
