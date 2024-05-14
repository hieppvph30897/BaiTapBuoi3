import java.util.Scanner

data class Nguoi(
    val hoTen: String,
    val tuoi: Int,
    val queQuan: String,
    val maSoGV: String
)

data class CBGV(
    val nguoi: Nguoi,
    val luongCung: Double,
    val luongThuong: Double,
    val tienPhat: Double
) {
    val luongThucLinh: Double
        get() = luongCung + luongThuong - tienPhat

    override fun toString(): String {
        return "Họ tên: ${nguoi.hoTen}, Tuổi: ${nguoi.tuoi}, Quê quán: ${nguoi.queQuan}, Mã số GV: ${nguoi.maSoGV}, " +
                "Lương cứng: $luongCung, Lương thưởng: $luongThuong, Tiền phạt: $tienPhat, Lương thực lĩnh: $luongThucLinh"
    }
}

class QuanLyCBGV {
    private val danhSachCB = mutableListOf<CBGV>()

    fun themCB(cbgv: CBGV) {
        danhSachCB.add(cbgv)
    }

    fun xoaCB(maSoGV: String) {
        danhSachCB.removeIf { it.nguoi.maSoGV == maSoGV }
    }

//    fun timKiemCB(maSoGV: String): CBGV? {
//        return danhSachCB.find { it.nguoi.maSoGV == maSoGV }
//    }

    fun hienThiCB() {
        danhSachCB.forEach { println(it) }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val quanLyCB = QuanLyCBGV()

    while (true) {
        println("\nVui lòng chọn:")
        println("1. Thêm cán bộ giáo viên")
        println("2. Xóa cán bộ giáo viên theo mã số")
        println("3. Hiển thị danh sách cán bộ giáo viên")
//        println("4. Tìm kiếm cán bộ giáo viên theo mã số")
        println("4. Thoát")
        print("Lựa chọn của bạn: ")

        when (scanner.nextInt()) {
            1 -> {
                scanner.nextLine() // Consume newline

                print("Nhập họ tên: ")
                val hoTen = scanner.nextLine()

                print("Nhập tuổi: ")
                val tuoi = scanner.nextInt()

                scanner.nextLine() // Consume newline
                print("Nhập quê quán: ")
                val queQuan = scanner.nextLine()

                print("Nhập mã số giáo viên: ")
                val maSoGV = scanner.nextLine()

                print("Nhập lương cứng: ")
                val luongCung = scanner.nextDouble()

                print("Nhập lương thưởng: ")
                val luongThuong = scanner.nextDouble()

                print("Nhập tiền phạt: ")
                val tienPhat = scanner.nextDouble()

                val nguoi = Nguoi(hoTen, tuoi, queQuan, maSoGV)
                val cbgv = CBGV(nguoi, luongCung, luongThuong, tienPhat)
                quanLyCB.themCB(cbgv)
            }
            2 -> {
                scanner.nextLine() // Consume newline

                print("Nhập mã số giáo viên để xóa: ")
                val maSoGV = scanner.nextLine()
                quanLyCB.xoaCB(maSoGV)
            }
            3 -> {
                println("Danh sách cán bộ giáo viên:")
                quanLyCB.hienThiCB()
            }
//            4 -> {//                scanner.nextLine() // Consume newline
////
////                print("Nhập mã số giáo viên để tìm kiếm: ")
////                val maSoGV = scanner.nextLine()
////                val cbgv = quanLyCB.timKiemCB(maSoGV)
////                if (cbgv != null) {
////                    println(cbgv)
////                } else {
////                    println("Không tìm thấy giáo viên có mã số $maSoGV")
////                }
////            }
            4 -> return
            else -> println("Lựa chọn không hợp lệ, vui lòng chọn lại.")
        }
    }
}