package com.study


class Node(val data: String, var next : Node? = null)


class LinkedList {
    private var head: Node? = null

    fun empty(): Boolean {
        return head == null
    }

    fun size(): Int {
        var count = 0
        var current = head
        while (current != null) {
            count++
            current = current.next
        }
        return count
    }

    fun addFirst(data: String) {
        val new_node = Node(data)
        new_node.next = head
        head = new_node
    }

    fun addlast(data: String) {
        val new_node = Node(data)
        if (empty()) {
            head = new_node
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }

            current?.next = new_node
        }

    }

    fun removeFirst(): String? {
        if (empty()) {
            return null
        }
        val data = head?.data
        head = head?.next
        return data
    }

    fun removeLast(): String? {
        if (empty()) {
            return null
        }

        if (head?.next == null) {
            val data = head?.data
            head = null
            return data
        }

        var current = head
        var prev: Node? = null
        while (current?.next != null) {
            prev = current
            current = current.next
        }


        val data = current?.data
        prev?.next = null
        return data


    }
    fun insetByIndex(index: Int,data: String) {
        if (index < 0 || index > size()) {
            println("out of index,${size()},${index}")

        }
        else if(index == 0){
            addFirst(data)
        }else if(size() == index){
            addlast(data)
        }else{
            val new_node = Node(data)
            var current_index = 1
            var current = head?.next
            var prev = head

            while (current_index != index) {

                prev = current
                current = current?.next
                current_index++
            }

                prev?.next = new_node
                new_node.next = current

        }

    }

    fun deleteByIndex(index: Int) {
        if (index < 0 || index > size()) {
            println("out of index,${size()},${index}")

        }
        else if(index == 0){
            removeFirst()
        }else if(size() == index){
            removeLast()
        }else{
            var current_index = 1
            var current = head?.next
            var prev = head

            while (current_index != index) {

                prev = current
                current = current?.next
                current_index++
            }
                prev?.next = current?.next

        }

    }
    fun getByIndex(index: Int): String? {
        if (index < 0 || index >= size()) {
            println("out of index")
        }
        var current = head
        var current_index = 0

        while (current != null && current_index < index) {
            current = current.next
            current_index++
        }

        return current?.data


    }

    fun deletebydata(data: String){
        var current = head?.next
        var prev = head
        while(current?.data != data){
            prev = current
            current = current?.next
        }
        prev?.next = current.next


    }
    fun getByData(data:String) {
        var current_index = 0
        var current = head


        while(current != null){
            if(current.data == data){
                println(current_index)
            }

            current = current.next
            current_index++
        }
    }
    fun printList() {
        var current = head
        while (current != null) {
            print("${current!!.data}->")
            current = current!!.next
        }
    }

}
fun main(){
        val linked_list = LinkedList()
        linked_list.addFirst("6")
        linked_list.addlast("9")
        linked_list.insetByIndex(0,"3")
        linked_list.insetByIndex(1,"2")
        linked_list.insetByIndex(0,"1")
        linked_list.insetByIndex(2,"4")
        linked_list.deletebydata("6")
        linked_list.printList()

}