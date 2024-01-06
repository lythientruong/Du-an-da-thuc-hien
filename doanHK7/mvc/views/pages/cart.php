<table class="table">
    <button><a href="/doan3/admin/adminAddProduct">Thêm SP</a></button>
  <thead>
    <tr>
    <th scope="col">Mã SP</th>
      <th scope="col">Tên SP</th>
      <th scope="col">Số lượng</th>
      <th scope="col">Giá</th>
    </tr>
  </thead>
  <tbody>
    <?php
        while($row = mysqli_fetch_array($data["sanpham"])){
    ?>
    <tr>
      <th scope="row"><?php echo $row['masp']; ?></th>
      <td><?php echo $row['tensp']; ?></td>
      <td><?php echo $row['soluong']; ?></td>
      <td><?php echo $row['giaban']; ?></td>
      <td><button><a href="delete&id=<?php  echo $row['masp']; ?>">Xóa</a></button></td>
    </tr>
    <?php } ?>
  </tbody>
  <button><a href="#">Thanh toán</a></button>
</table>