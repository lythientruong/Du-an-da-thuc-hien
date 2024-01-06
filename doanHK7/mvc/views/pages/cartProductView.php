<table class="table">
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
    </tr>
    <?php } ?>
  </tbody>
</table>