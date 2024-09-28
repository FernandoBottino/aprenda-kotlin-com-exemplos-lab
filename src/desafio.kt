

import kotlin.time.Duration

enum class Nivel{BASICO, INTERMEDIARIO, DIFICIL}
data class Usuario(val id: String, val nome: String)
data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(
    val nome: String,
    val nivel: Nivel,
    var conteudos: List<ConteudoEducacional>
) {
    private val inscritos = mutableSetOf<Usuario>()
    fun matricular(usuario: Usuario) {
        if (inscritos.contains(usuario)) {
            println("O usuário ${usuario.nome} já está matriculado na  $nome.")
        } else {
            inscritos.add(usuario)
            println("O usuário ${usuario.nome} foi matriculado na  $nome.")
        }
    }

    fun listarInscritos() {
        if (inscritos.isEmpty()) {
            println("Nenhum aluno matriculado na  $nome.")
        } else {
            println("Alunos matriculados na  $nome:")
            inscritos.forEach{ println("- ${it.nome}") }
        }
    }
}

fun main() {
    // Criando conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 120)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 90)

    // Criando uma formação
    val formacaoKotlin = Formacao("Formação em Kotlin", Nivel.BASICO, listOf(conteudo1, conteudo2))

    // Criando usuários
    val usuario1 = Usuario("1", "Alice")
    val usuario2 = Usuario("2", "Bob")

    // Simulando matrículas
    formacaoKotlin.matricular(usuario1) // Alice se matricula
    formacaoKotlin.matricular(usuario2) // Bob se matricula
    formacaoKotlin.matricular(usuario1) // Alice tenta se matricular novamente

    // Listando inscritos
    formacaoKotlin.listarInscritos()
}

