package cz.cvut.fit.feeder

import java.util.*

class DataProvider {
    companion object{
        val data: Map<Int, Thumbnail> get(){
            val data = mutableMapOf<Int, Thumbnail>()

            for (i in 0..25){
                data[i] = Thumbnail("Thumbnail $i", description, "www.google.com")
            }

            return data
        }

        private val description: String get() {

            val descriptions = arrayOf(
                    "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Praesent id justo in neque elementum ultrices. Nulla quis diam. Nulla non arcu lacinia neque faucibus fringilla. Mauris elementum mauris vitae tortor.\n",
                    "Aliquam erat volutpat. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?\n",
                    "Phasellus enim erat, vestibulum vel, aliquam a, posuere eu, velit. Duis sapien nunc, commodo et, interdum suscipit, sollicitudin et, dolor. Nullam at arcu a est sollicitudin euismod. Etiam quis quam. Duis bibendum, lectus ut viverra rhoncus, dolor nunc faucibus libero, eget facilisis enim ipsum id lacus. Aliquam ornare wisi eu metus.\n",
                    "Mauris tincidunt sem sed arcu. Nulla turpis magna, cursus sit amet, suscipit a, interdum id, felis. Sed vel lectus. Donec odio tempus molestie, porttitor ut, iaculis quis, sem. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Maecenas sollicitudin.\n",
                    "Cras pede libero, dapibus nec, pretium sit amet, tempor quis. Praesent id justo in neque elementum ultrices. Phasellus et lorem id felis nonummy placerat. Nullam faucibus mi quis velit. Aliquam id dolor. Nullam eget nisl. Curabitur bibendum justo non orci. Mauris metus. Integer in sapien. Nulla est.\n"
            )

            val index = Random().nextInt(5)
            return descriptions[index]
        }
    }
}