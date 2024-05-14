package com.example.baitapbuoi3



import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Scanner

//Thư viện trung tâm đại học quốc gia có nhu cầu quản lý việc mượn, trả sách. Sinh viên đăng ký tham gia mượn sách thông qua thẻ mà thư viện cung cấp.
//
//Với mỗi thẻ sẽ lưu các thông tin sau: Mã phiếu mượn, ngày mượn, hạn trả, số hiệu sách, và các thông tin cá nhân của sinh viên mượn sách. Các thông tin của sinh viên mượn sách bao gồm: Họ tên, tuổi, lớp.
//
//Để đơn giản cho ứng dụng console. Chúng ta mặc định ngày mượn, ngày trả là số nguyên dương.
//
//Yêu cầu 1: Xây dựng lớp SinhVien để quản lý thông tin của mỗi sinh viên.
//
//Yêu cầu 2: Xây dựng lớp TheMuon để quản lý việc mượn trả sách của các sinh viên.
//
//Yêu cầu 3: Xây dựng các phương thức: Thêm, xoá theo mã phiếu mượn và hiển thị thông tin các thẻ mượn.

data class SinhVien(
    val hoTen: String,
    val tuoi: Int,
    val lop: String
)
data class TheMuon(
    val maPhieuMuon: String,
    val ngayMuon: LocalDate,
    val hanTra: LocalDate,
    val soHieuSach: String,
    val sinhVien: SinhVien
) {
    override fun toString(): String {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        return "Mã phiếu mượn: $maPhieuMuon, Ngày mượn: ${ngayMuon.format(formatter)}, Hạn trả: ${hanTra.format(formatter)}, Số hiệu sách: $soHieuSach, " +
                "Sinh viên: [Họ tên: ${sinhVien.hoTen}, Tuổi: ${sinhVien.tuoi}, Lớp: ${sinhVien.lop}]"
    }
}
class QuanLyTheMuon {
    private val danhSachTheMuon = mutableListOf<TheMuon>()

    fun themTheMuon(theMuon: TheMuon) {
        danhSachTheMuon.add(theMuon)
    }

    fun xoaTheMuon(maPhieuMuon: String) {
        val iterator = danhSachTheMuon.iterator()
        while (iterator.hasNext()) {
            if (iterator.next().maPhieuMuon == maPhieuMuon) {
                iterator.remove()
                println("Đã xóa thành công")
                return
            }
        }
        println("Không tìm thấy thẻ mượn với mã phiếu mượn: $maPhieuMuon")
    }

    fun hienThiTheMuon() {
        if (danhSachTheMuon.isEmpty()) {
            println("Không có thẻ mượn nào trong danh sách.")
        } else {
            danhSachTheMuon.forEach { println(it) }
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val quanLyTheMuon = QuanLyTheMuon()
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    while (true) {
        println("\nChọn hành động:")
        println("1. Thêm thẻ mượn")
        println("2. Xóa thẻ mượn theo mã phiếu mượn")
        println("3. Hiển thị danh sách thẻ mượn")
        println("4. Thoát")
        print("Lựa chọn của bạn: ")

        when (scanner.nextInt()) {
            1 -> {
                scanner.nextLine() // Consume newline

                print("Nhập mã phiếu mượn: ")
                val maPhieuMuon = scanner.nextLine()

                print("Nhập ngày mượn (dd/MM/yyyy): ")
                val ngayMuon = LocalDate.parse(scanner.nextLine(), formatter)

                print("Nhập hạn trả (dd/MM/yyyy): ")
                val hanTra = LocalDate.parse(scanner.nextLine(), formatter)

                print("Nhập số hiệu sách: ")
                val soHieuSach = scanner.nextLine()

                print("Nhập họ tên sinh viên: ")
                val hoTen = scanner.nextLine()

                print("Nhập tuổi sinh viên: ")
                val tuoi = scanner.nextInt()

                scanner.nextLine() // Consume newline
                print("Nhập lớp sinh viên: ")
                val lop = scanner.nextLine()

                val sinhVien = SinhVien(hoTen, tuoi, lop)
                val theMuon = TheMuon(maPhieuMuon, ngayMuon, hanTra, soHieuSach, sinhVien)
                quanLyTheMuon.themTheMuon(theMuon)
                println("Thêm thẻ mượn thành công.")
            }
            2 -> {
                scanner.nextLine() // Consume newline

                print("Nhập mã phiếu mượn để xóa: ")
                val maPhieuMuon = scanner.nextLine()
                quanLyTheMuon.xoaTheMuon(maPhieuMuon)
            }
            3 -> {
                println("Danh sách thẻ mượn:")
                quanLyTheMuon.hienThiTheMuon()
            }
            4 -> return
            else -> println("Lựa chọn không hợp lệ, vui lòng chọn lại.")
        }
    }
}




            