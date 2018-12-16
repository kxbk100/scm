$("#save").hide();

// 将所有表格的数据更新至数据库
function updateTable(type, n) {
  var suffix;
  switch (type) {
    case 0:
      suffix = "/scm/teachers"
      break;
    case 1:
      suffix = "scm/talents"
      breakl;
    case 1:
      suffix = "scm/science"
      break;
    case 2:
      suffix = "scm/talents"
      break;
    case 3:
      suffix = "scm/subject"
      break;
    case 4:
      suffix = "scm/international"
      break;
  }
  var table = $("#table" + n).tableToJSON({
    ignoreHiddenRows: false,
    headings: ['id', 'goal', 'nextgoal', "deadline"],
    onlyColumns: [0, 3, 4, 5]
  });
  table.shift();
  // console.log(JSON.stringify(table));
  console.log(JSON.stringify(table));
  $.ajax({
    url: ip + suffix,
    type: "POST",
    headers: {
      'Content-Type': 'application/json'
    },
    data: JSON.stringify(table),
    success: function (msg) {
      console.log("success");
    },
    error: function (e) {
      console.log("error");
    }
  });
}

// 点击编辑按钮触发事件
function edit(n) {
  $("#edit" + n).addClass("hidden");
  $("#add" + n).removeClass("hidden");
  $("#save" + n).removeClass("hidden");
  $("#cancel" + n).removeClass("hidden");
  var number = $("#table" + n + " span[name='number']");
  var goal = $("#table" + n + " input[name='goal']");
  for (var i = 0; i < number.length; i++) {
    $(goal[i]).val($(number[i]).html());
  }
  number.hide();
  goal.show();
}

// 点击保存按钮触发事件
function save(type, n) {
  $("#edit" + n).removeClass("hidden");
  $("#add" + n).addClass("hidden");
  $("#save" + n).addClass("hidden");
  $("#cancel" + n).addClass("hidden");
  var number = $("#table" + n + " span[name='number']");
  var goal = $("#table" + n + " input[name='goal']");
  for (var i = 0; i < goal.length; i++) {
    $(number[i]).html($(goal[i]).val());
  }
  goal.hide();
  number.show();
  updateTable(type, n);
}

// 点击新增自设指标触发事件
function add(n) {
  $("#self").append(`
          <tr>
            <td class="text-center hidden">
              <input type="hidden" value="id">
            </td>
            <td class="text-center">
              <input type="text" class="form-control input-sm" name="goal" placeholder="请设置具体指标">
              <strong>
                <span name="number"></span>
              </strong>
            </td>
            <td class="text-center">
              <strong>
                <span>0</span>
              </strong>
            </td>
            <td class="text-center">
              <input type="number" class="form-control input-sm" name="goal" placeholder="">
              <strong>
                <span name="number"></span>
              </strong>
            </td>
            <td class="text-center" name="stage">
              <input type="number" class="form-control input-sm" name="goal" placeholder="">
              <strong>
                <span name="number"></span>
              </strong>
            </td>
            <td class="text-center">
              <input type="date" class="form-control input-sm" name="goal" placeholder="">
              <strong>
                <span name="number"></span>
              </strong>
            </td>
            <td class="text-center">
              <div class="progress progress-striped active">
                <div id="process" class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"
                  style="width: 0%">0%</div>
              </div>
            </td>
          </tr>
          `).children(':last').hide().fadeIn(300);
  $("#table" + n + "[name='number']").hide();
  $("[name='stage']").hide();
}

// 点击取消触发事件
function cancel(n) {
  $("#edit" + n).removeClass("hidden");
  $("#add" + n).addClass("hidden");
  $("#save" + n).addClass("hidden");
  $("#cancel" + n).addClass("hidden");
  var number = $("#table" + n + " span[name='number']");
  var goal = $("#table" + n + " input[name='goal']");
  number.show();
  goal.hide();
}

// 点击设置阶段检查事件中的保存触发事件
$("#setdeadline").on('click', function () {
  $("#showdeadline").html("下一阶段截止时间：" + $("#deadline").val());
  $('#modal').modal('hide');
  $("#set").hide();
  $("#save").show();
  $("[name='stage']").fadeIn(300);
  var number = $("[name='stage'] [name='number']");
  var goal = $("[name='stage'] [name='goal']");
  for (var i = 0; i < number.length; i++) {
    $(goal[i]).val($(number[i]).html());
  }
  number.hide();
  goal.show();
});

// // 输入下一阶段目标值后触发事件
// $("#save").on('click', function () {
//   $("#save").hide();
//   $("#set").show();
//   var number = $("[name='stage'] [name='number']");
//   var goal = $("[name='stage'] [name='goal']");
//   for (var i = 0; i < goal.length; i++) {
//     $(number[i]).html($(goal[i]).val());
//   }
//   goal.hide();
//   number.show();
//   for (i = 0; i < 6; i++) {
//     updateTable(i);
//     // 下一阶段
//   }


