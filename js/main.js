$("#save").hide();

// 将所有表格的数据更新至数据库
function updateTable(n) {
  var table = $("#table" + n).tableToJSON({
    ignoreHiddenRows: false,
    headings: ['id', 'content', 'now', 'goal', 'next_goal', "dead_line"]
  });
  table.shift();
  console.log(JSON.stringify(table));
  $.ajax({
    type: "POST",
    url: "http://192.168.1.114:8080/goal/updateGoal",
    data: { table: JSON.stringify(table) },
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
function save(n) {
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
  updateTable(n);
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

// 输入下一阶段目标值后触发事件
$("#save").on('click', function () {
  $("#save").hide();
  $("#set").show();
  var number = $("[name='stage'] [name='number']");
  var goal = $("[name='stage'] [name='goal']");
  for (var i = 0; i < goal.length; i++) {
    $(number[i]).html($(goal[i]).val());
  }
  goal.hide();
  number.show();
  for (i = 0; i < 6; i++) {
    updateTable(i);
  }
})

