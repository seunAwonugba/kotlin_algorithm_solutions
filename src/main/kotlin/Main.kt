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
}

//    #
//   ##
//  ###
// ####


