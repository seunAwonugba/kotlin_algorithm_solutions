fun main() {
    val arrayList = listOf(
        5, 1, -5, 0, 2, 10, -4, 15, 30, 11, 35, 11, -54, 22, 10, 0, -50, 21, -15, 12, 20, -14, 25, 85, 71, 0, -35, 12, 100, 31, 13
    )
    //find a value from a list


    //linear search time complexity of O(n)
    fun checkNumberExist(num : Int, arr : List<Int>) : Boolean{
        for (i in arr){
            if (i == num){
                return true
            }
        }
        return false
    }

    println(checkNumberExist(num = 15, arr = arrayList))

//    logarithmic search time complexity of Ologn
    fun optimisedCheckNumberExist(num : Int, arr : List<Int>) : Boolean{
        val sortedList = arr.sorted()

        val middleIndex = (sortedList.size)/2

        val middleIndexValue = sortedList[middleIndex]

        when{
            arr.isEmpty() -> {
                return false
            }

            num >= middleIndexValue -> {
                for (i in middleIndex .. sortedList.lastIndex){
                    if (i == num){
                        return true
                    }
                }
            }

            else -> {
                for (i in sortedList[0] .. middleIndex){
                    if (i == num){
                        return true
                    }
                }
            }


        }

//        if (arr.isEmpty()){
//            return false
//        }
//
//        if (num >= middleIndexValue){
//            for (i in middleIndex..sortedList.lastIndex){
//                if (i == num){
//                    return true
//                }
//            }
//        }else{
//            for (i in sortedList[0] .. middleIndex){
//                if (i == num){
//                    return true
//                }
//            }
//
//        }

        return false

    }

    println(optimisedCheckNumberExist( num = 111, arr = arrayList))


    fun sumOfANumberFromRange(n : Int) : Int{
        var result = 0
        for (i in 1..n){
            result += i
        }
        return result
    }

    println(sumOfANumberFromRange(10000))

    //hackerrank algorithm
    //plus minus
    //Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero
    fun plusMinus(arr : List<Int>){
        val arrSize = (arr.size).toFloat()
        var positive = 0f
        var negative = 0f
        var zero = 0f
        for (i in arr){
            when {
                0 < i -> {
                    positive++
                }
                0 > i -> {
                    negative++
                }
                else -> {
                    zero++
                }

            }
        }
        println("%.6f".format(positive/arrSize))
        println("%.6f".format(negative/arrSize))
        println("%.6f".format(zero/arrSize))

    }

    plusMinus(arrayList)

    var newArray = listOf<Int>(3,2,3)

    fun twoSums(arr : List<Int>, target: Int) : IntArray{
        val twoArray = intArrayOf()

        for (i in 0.. arr.size-1){
            var reverseValue = target - arr[i]

            for (e in 0..arr.size-1){
                if (reverseValue == arr[e]){
                    return twoArray.plus(i).plus(e)

                }
            }


        }

        return twoArray
    }

    println(twoSums(newArray, 9))

    fun staircase(n : Int){
        for (i in 1..n){
            val requiredSpace = n - i

            for (j in 1 .. requiredSpace){
                print(" ")
            }

            for (j in 1 .. i){
                print("#")
            }
            println()
        }
    }

    staircase(3)

    fun minMaxSum(arr : Array<Int>){
        var sortedArray = arr.sorted()

        var totalSum = 0
        for (i in sortedArray){
            totalSum += i
        }

        val maxVal = totalSum - sortedArray.first()
        val minVal = totalSum - sortedArray.last()

        println("$minVal $maxVal" )
    }

    minMaxSum(arr = arrayOf(1,3,5,7,9))

    fun birthdayCakeCandles(candles : Array<Int>) : Int{
        var maxValue = 0
        var noOfTimes = 0
        for(i in candles){
            if (i > maxValue) {
                maxValue = i
                println(maxValue)
            }
        }

        for(i in candles){
            if(maxValue == i){
                noOfTimes++
            }
        }

        return noOfTimes

    }



    println(birthdayCakeCandles(candles = arrayOf(4,4,1,3)))

    fun gradingStudents(grades: Array<Int>): Array<Int> {
        // Write your code here
        var returnArray = arrayOf<Int>()
        for(i in grades){
            when{
                i < 38 -> {
                    returnArray+=i
                }
                i % 10 == 5 || i % 10 == 0 ->{
                    returnArray+=i
                }
                i % 10 > 5 -> {
                    println(i)
                    val remainder = 10 - i%10
                    if(remainder < 3){
                        returnArray+= i+ remainder
                    }else{
                        returnArray+=i
                    }
                }
                i % 10 < 5 -> {
                    val reminder = 5-i%10
                    if(reminder < 3){
                        returnArray+= i + reminder
                    }else{
                        returnArray+=i
                    }
                }
            }
        }
        return returnArray

    }

    println(gradingStudents(arrayOf(73,67,38,33)).contentToString())

    fun breakingTheRecords(scores : Array<Int>) : Array<Int>{
        var maxRecArr = listOf<Int>(scores.first())
        var minRecArr = listOf<Int>(scores.first())
        var maxArrNo = 0
        var minArrNo = 0
        val totalArr = arrayOf<Int>()

        for (i in 1.. scores.size-1){
            when{
                scores[i] > scores[i-1] -> {
                    maxRecArr.plus(scores[i])
                    if (maxRecArr.last() < scores[i] ){
                        maxArrNo++
                    }
                }
                scores[i] < scores[i - 1] -> {
                    minRecArr.plus(scores[i])
                    if (minRecArr.last() > scores[i]){
                        minArrNo++
                    }
                }
            }

        }

        return totalArr.plus(maxArrNo).plus(minArrNo)
    }

    println(breakingTheRecords(arrayOf(3 ,4 ,21 ,36 ,10 ,28 ,35 ,5 ,24 ,42)).contentToString())

    fun birthday(s: Array<Int>, d: Int, m: Int): Int {
        // Write your code here
        var segment = 0
        for(i in 0..m){
            when(i){
                1 -> {
                    for (j in s){
                        if (j == d){
                            segment++
                        }
                    }
                }
                2 -> {
                    for (j in 1..s.size-1){
                        if (s[j] + s[j-1] == d){
                            segment++
                        }
                    }
                }
                3 -> {
                    for (j in 2.. s.size-1){
                        if (s[j] + s[j-1]+ s[j-2] == d){
                            segment++
                        }
                    }
                }
                4 -> {
                    for (j in 3.. s.size-1){
                        if (s[j] + s[j-1]+ s[j-2]+ s[j-3] == d){
                            segment++
                        }
                    }
                }
                5 -> {
                    for (j in 4.. s.size-1){
                        if (s[j] + s[j-1]+ s[j-2]+ s[j-3]+ s[j-4] == d){
                            segment++
                        }
                    }
                }
                6 -> {
                    for (j in 5.. s.size-1){
                        if (s[j] + s[j-1]+ s[j-2]+ s[j-3]+ s[j-4]+ s[j-5] == d){
                            segment++
                        }
                    }
                }
                7 -> {
                    for (j in 6.. s.size-1){
                        if (s[j] + s[j-1]+ s[j-2]+ s[j-3]+ s[j-4]+ s[j-5]+ s[j-6]  == d){
                            segment++
                        }
                    }
                }
            }
        }

        return segment

    }

    println(birthday(s= arrayOf(1,2,1,3,2), d = 3, m = 2))

    fun divisibleSumPairs(k: Int, ar: Array<Int>): Int {
        // Write your code here
        var counter = 0
        for(i in 0..ar.size-1){
            for(j in i+1 ..ar.size-1){
                if((ar[i] + ar[j]) % k == 0 ){
                    counter++
                }
            }
        }
        return counter

    }

    println(divisibleSumPairs(k = 5, ar= arrayOf(1,2,3,4,5,6)))


    fun migratoryBirds(arr : Array<Int>) : Int {
        val returnedMap = mutableMapOf<Int, Int>()

        for (i in arr){
            if (returnedMap.keys.contains(i)){
                returnedMap.merge(i, 1, Int::plus)
            }else{
                returnedMap.put(i, 1)
            }
        }

        val sortedMap = returnedMap.toSortedMap()

        return sortedMap.maxBy { it.value }.key

    }

    println(migratoryBirds(arr = arrayOf(1,1,2,2,3)))

    fun salesByMatch(arr : Array<Int>) : Int{
        var table = hashMapOf<Int, Int>()
        var value = 0

        for (i in arr){
            if (table.keys.contains(i)){
                table.merge(i, 1, Int::plus)
            }else{
                table.put(i,1)
            }
        }
        println(table)

        for (i in table.values){
            when{
                i >= 2 -> {
                    if (i%2 == 0){
                        value += (i/2)
                    }else{
                        value+= (i/2)
                    }
                }

            }
        }

        return value

    }

    println(salesByMatch(arr = arrayOf(1,2,1,2,1,3,2)))



}


