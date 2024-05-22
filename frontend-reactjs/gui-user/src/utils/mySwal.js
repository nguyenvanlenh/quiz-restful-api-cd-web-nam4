import Swal from "sweetalert2";
import withReactContent from "sweetalert2-react-content";

const MySwal = withReactContent(Swal);
export const submitExaminingSwal = () => {
  return MySwal.fire({
      title: "Xác nhận nộp bài",
      text: "Bạn có chắc chắn muốn nộp bài không?",
      icon: "warning",
      showCancelButton: true,
      confirmButtonText: "Đồng ý",
      cancelButtonText: "Hủy",
      reverseButtons: true,
  }).then((result) => {
      return result.isConfirmed; // Trả về kết quả từ SweetAlert2
  });
};
