fun main() {
    val arrayList = listOf(
        5, 1, -5, 2, 10, -4, 15, 30, 11, 35, 11, -54, 22, 10 -50, 21, -15, 12, 20, -14, 25, 85, 71, -35, 12, 100, 31, 13
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
}