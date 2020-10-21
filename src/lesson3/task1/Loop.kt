@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import lesson1.task1.sqr
import kotlin.math.abs
import kotlin.math.pow
//import kotlin.math.sin
import kotlin.math.sqrt

/**
 * Пример
 *
 * Вычисление факториала
 */

fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result *= i // Please do not fix in master
    }
    return result
}
//fun factorial2 (n: Int): Double = if (n < 2) 1.0 else n * factorial(n - 1)

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */

fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int =
        when {
            n < 10 -> 1
            else -> digitNumber(n / 10) + 1
        }

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int = when (n) {
    1 -> 1
    2 -> 1
    else -> fib(n - 2) + fib(n - 1)
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    //val x
    val max = m * n
    for (ii in 1..max) {

        if ((ii % m == 0) && (ii % n == 0)) {
            return ii
        }

    }
    return 0
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    //var i = 1
    for (i in 2..n) {

        if (n % i == 0) {
            return i
        }

    }
    return 0
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var i = n - 1
    while (i > 0) {
        if (n % i == 0) {
            println("final $i")
            return i
        }
        i--
    }
    println("final2 $i")
    return 0
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean = if (m > n) (simple(m, n)) else (simple(n, m))

fun simple(m: Int, n: Int): Boolean {
    var i = n
    while (i > 1) {
        if ((n % i == 0) && (m % i == 0)) {
            //  println("final $i")
            return false
        }
        i--
    }
    // println("final2 $i")
    return true
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {

    val mini: Int = sqrt(m.toDouble()).toInt()
    val maxi: Int = sqrt(n.toDouble()).toInt()
    println("m= $m mini= $mini n= $n maxi = $maxi")

    for (i in mini..maxi) {
        //  println(sqr(i))
        if ((m <= sqr(i)) && (n >= sqr(i))) {
            println(i)
            return true

        }
    }
    return false
}

/**
 * Средняя
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     следующий X = X /2
 *   ИНАЧЕ
 *     следующий X = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var z: Int
    z = x
    var i = 0
    while (z != 1) {
        if (z % 2 == 0)
            z /= 2
        else z = z * 3 + 1
        i++
    }
    println(i)
    return i
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */

fun sin(x: Double, eps: Double): Double {
    var p = x
    var s = x
    var n = 3
    var i = 1
    while (abs(p) > eps)  // {Условие выхода: очередной член ряда по модулю меньше eps}
    {
        p = x.pow(n) / factorial(n)// {Вычисление очередного члена ряда}
        if (i % 2 != 0) {
            s -= p
        } else {
            s += p
        }
        n += 2
        i++
    }
    return s
}


/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double {
    var p = x
    var s = 1.0
    var n = 2
    var i = 1
    while (abs(p) > eps) {
        p = x.pow(n) / factorial(n)
        if (i % 2 != 0) {
            s -= p
        } else {
            s += p
        }
        n += 2
        i++
    }
    return s
}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var x = n
    var i = 0
    while (x > 0) {
        i = i * 10 + x % 10
        x /= 10
    }
    return i
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    var v = n
    var divisor = 1
    while (v / divisor >= 10) {
        divisor *= 10
        //println(divisor)
    }
    while (v != 0) {
        val leading = v / divisor
        val trailing = v % 10
        if (leading != trailing) return false
        v = (v % divisor) / 10
        divisor /= 100
    }
    return true
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var v = n
    var divisor = 1
    if (n < 10) return false
    while (v / divisor >= 10) {
        divisor *= 10
        //   println("divisor= $divisor")
    }
    while (v >= 10) {
        val leading = v / divisor
        //println("v/divisor= $leading")
        v = (v % divisor)
        divisor /= 10
        val trailing = v / divisor
        // println("n= $n leading= $leading v= $v divisor = $divisor trailing= $trailing")
        if (leading != trailing) return true

    }
    return false
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var v = 0
    var i = 0
    var x: Int
    var num: Int
    var w = 0
    while (v <= n) {
        i++
        x = digitNumber(sqr(i))
        v += x
        println("i= $i v=$v")
        if (v >= n) {
            println("final i= $i v=$v x=$x")
            num = sqr(i)
            while ((v - n) >= 0) {
                w = num % 10
                num /= 10
                v--
                println("v $v n= $n num $num")
            }
            return w
        }
    }
    return w
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var v = 0
    var i = 0
    var x: Int
    var num: Int
    var w = 0

    while (v <= n) {
        i++
        x = digitNumber(fib(i))
        v += x
        println("i= $i v=$v")
        if (v >= n) {
            println("final i= $i v=$v x=$x")
            num = fib(i)
            while ((v - n) >= 0) {
                w = num % 10
                num /= 10
                v--
                println("v $v n= $n num $num")
            }
            return w
        }
    }
    return w
}

/**
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
