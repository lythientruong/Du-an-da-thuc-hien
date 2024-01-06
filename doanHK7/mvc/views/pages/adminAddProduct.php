
<form method="POST" name="addproduct">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Tên sản phẩm</label>
    <input type="text" class="form-control"  aria-describedby="tensp" name="tensp">
  </div>
  <div class="mb-3">
    <label class="form-label">Giá bán</label>
    <input type="text" class="form-control" aria-describedby="giaban" name="giaban">
  </div>
  <div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">Chi tiết</label>
  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="chitiet"></textarea>
  </div>
  <div class="mb-3">
    <label class="form-label">Hình ảnh</label>
    <input type="text" class="form-control" aria-describedby="hinhanh" name="hinhanh">
  </div>
  <div class="mb-3">
    <label class="form-label">Số lượng</label>
    <input type="text" class="form-control" aria-describedby="soluong" name="soluong">
  </div>
  <div class="mb-3">
    <label class="form-label">Mã loại</label>
    <input type="text" class="form-control" aria-describedby="maloai" name="maloai">
  </div>
  <div class="mb-3">
    <label class="form-label">Mã TH</label>
    <input type="text" class="form-control" aria-describedby="math" name="math">
  </div>
 
  <button type="submit" class="btn btn-primary" name="themsp" style="text-decoration: none;">Thêm sản phẩm</button>
  <button style="text-decoration: none;"><a href="/doan3/admin/adminView">Quay lại trang chủ admin</a></button>
</form>