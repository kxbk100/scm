$("#save").hide();

// 初始化所有数据
$(function () {
  initial(url, parts);
});

// 用户表格信息
function userTable() {
  $.ajax({
    url: ip + '/scm/users/show',
    type: "get",
    cache: false,
    async: false,
    success: function (data) {
      console.log(data);
      $.each(data, function (i, item) {
        var id = item.id;
        var username = item.username;
        var name = item.name;
        var x = 1 + i;
        var table = `
                  <tr>                     
                    <td class="text-center">
                      <strong id="index">` + x + `</strong>
                    </td>
                    
                    <td class="text-center">
                      <strong>
                        <span id="username">`+ username + `</span>
                      </strong>
                    </td>
                    <td class="text-center">
                      <strong>
                        <span id="name">`+ name + `</span>
                      </strong>
                    </td>
                    <td class="text-center">
                        <a href="#modal-modify" data-toggle="modal" title="修改" id="modify" class="btn btn-effect-ripple btn-xs btn-info" onclick="modify(` + id + `)">
                          <i class="fa fa-pencil"></i>
                        </a>
                        <a href="#modal-reset" data-toggle="modal" title="重置密码" id="reset" class="btn btn-effect-ripple btn-xs btn-warning">
                          <i class="fa fa-refresh"></i>
                        </a>
                        <a href="#modal-delete" data-toggle="modal" title="删除" id="delete" class="btn btn-effect-ripple btn-xs btn-danger">
                          <i class="fa fa-times"></i>
                        </a>
                    </td>
                  </tr>                 
                  `
                  var del_modal = `
                    <button type="button" class="btn btn-effect-ripple btn-primary" onclick="del(` + id + `)" data-dismiss="modal">删除</button>
                    <button type="button" class="btn btn-effect-ripple btn-danger" data-dismiss="modal">取消</button>
                  `
                  var mdf_modal = `
                    <button type="button" class="btn btn-effect-ripple btn-primary" onclick="reset(` + id + `)" data-dismiss="modal">重置</button>
                    <button type="button" class="btn btn-effect-ripple btn-danger" data-dismiss="modal">取消</button>
                  `
                
        $("#user").append(table);
        $("#del_modal").html("");
        $("#del_modal").append(del_modal);
        $("#mdf_modal").html("");
        $("#mdf_modal").append(mdf_modal);
      })

    },
    error: function (e) {
    }
  })
}

// 将所有表格的数据更新至数据库
function updateTable(type, n) {
  var suffix;
  switch (type) {
    case 0:
      suffix = "/scm/teachers"
      break;
    case 1:
      suffix = "/scm/talents"
      break;
    case 2:
      suffix = "/scm/science"
      break;
    case 3:
      suffix = "/scm/subject"
      break;
    case 4:
      suffix = "/scm/international"
      break;
  }
  var table = $("#table" + n).tableToJSON({
    ignoreHiddenRows: false,
    headings: ['id', 'content', 'goal', 'nextgoal', "deadline"],
    onlyColumns: [0, 1, 3, 4, 5]
  });
  table.shift();
  console.log(JSON.stringify(table));
  $.ajax({
    url: ip + suffix,
    type: "POST",
    async: false,
    headers: {
      'Content-Type': 'application/json'
    },
    data: JSON.stringify(table),
    success: function (msg) {
      console.log("success");
    },
    error: function (e) {
      console.log(e);
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
  if (nextdeadline == '') {
    $("[name='stage']").hide();
  }
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

// 页面数据初始化
function initial(url, parts) {
  $.ajax({
    url: ip + '/scm/' + url,
    type: 'GET',
    cache: false,
    async: false,
    success: function (data) {
      nextdeadline = data[0].nextdeadline ? data[0].nextdeadline : '';
      console.log(data);
      $.each(data, function (i, item) {
        var targetid = item.targetId;
        var pointsid = item.pointsId;
        var secondid = item.secondId;
        var content = item.content;
        var now = item.now ? item.now : 0;
        var goal = item.goal ? item.goal : 0;
        var nextgoal = item.nextgoal ? item.nextgoal : 0;
        var deadline = item.deadline ? item.deadline : '';
        var percent = parseInt((now / goal * 100) ? (now / goal * 100) : 0);
        var color;
        if (percent < 20) {
          color = "danger";
        } else if (percent >= 20 && percent <= 50) {
          color = "warning";
        } else if (percent > 50) {
          color = "primary";
        }
        if (percent > 100) {
          percent = 100;
        }
        var table = `
  <tr>
    <td class="text-center hidden">` + pointsid + `</td>
    <td class="text-center">
      <strong>` + content + `</strong>
    </td>
    <td class="text-center">
      <strong>
        <span>` + now + `</span>
      </strong>
    </td>
    <td class="text-center">
      <input type="number" class="form-control input-sm" name="goal" placeholder="">
      <strong>
        <span name="number">` + goal + `</span>
      </strong>
    </td>
    <td class="text-center" name="stage">
      <input type="number" class="form-control input-sm" name="goal" placeholder="">
      <strong>
        <span name="number">` + nextgoal + `</span>
      </strong>
    </td>
    <td class="text-center">
      <input type="date" class="form-control input-sm" name="goal" placeholder="">
      <strong>
        <span name="number">` + deadline + `</span>
      </strong>
    </td>
    <td class="text-center">
      <div class="progress progress-striped active">
        <div class="progress-bar progress-bar-` + color + `" role="progressbar" aria-valuenow="` + percent + `" aria-valuemin="0" aria-valuemax="100"
          style="width: ` + percent + `%">` + percent + `%</div>
      </div>
    </td>
  </tr>
  `
        for (var i = 0; i < parts.length; i++) {
          if (item.second == parts[i]) {
            $("#table" + i + " tbody").append(table);
          }
        }
      })
      $("[name='goal']").hide();

      $("[name='stage']").hide();

      if (nextdeadline != '') {
        $("#shownextdeadline").html("下一阶段截止时间：" + nextdeadline);
        $("[name='stage']").show();
        $("#nextdeadline").val(nextdeadline);
      }
    },
    error: function (e) {
      console.log(e)
    }
  })

}

// 设置下一阶段截止时间
$("#setnextdeadline").on('click', function () {
  nextdeadline = $("#nextdeadline").val()
  console.log(nextdeadline);
  $("#shownextdeadline").html("下一阶段截止时间：" + nextdeadline);
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
  $.ajax({
    url: ip + "/scm/" + url + "/nextdeadline",
    type: "POST",
    async: false,
    cache: false,
    data: {
      nextdeadline: nextdeadline
    },
    success: function (msg) {
      console.log(msg);
    },
    error: function (e) {
      console.log(e);
    }
  });
});

// 材料提交表格显示
function tableshow() {
  $.ajax({
    url: ip + '/scm/material/teacher/show?id=' + sessionStorage.id,
    type: "get",
    cache: false,
    async: false,
    success: function (data) {
      console.log(data);
      $.each(data, function (i, item) {
        var recordId = item.recordId;
        var type = item.type;
        var name = item.name;
        var date = item.date;
        var status = item.status;
        var table = `
              <tr>
                <td class="text-center">
                  <strong>`+ name +`</strong>
                </td>
                
                <td class="text-center">
                  <strong>
                    <span name="number">`+ date +`</span>
                  </strong>
                </td>

                <td class="text-center">
                  <a href="javascript:void(0)" class="label label-success" id="status">已通过</a>
                </td>
                <td class="text-center">
                        <a href="#modal_check" data-toggle="modal" title="查看" id="check" class="btn btn-effect-ripple btn-xs btn-info" onclick="check(`+ type +`,`+ recordId +`)">
                        <i class="fa fa-eye"></i>
                        </a>
                </td>  
              </tr>                            
              `
        $("#table").append(table);
      })

    },
    error: function (e) {
    }
  })
}

// 材料审核表格显示
function adminshow() {
  $.ajax({
    url: ip + '/scm/material/admin/show',
    type: "get",
    cache: false,
    async: false,
    success: function (data) {
      console.log(data);
      $.each(data, function (i, item) {
        var recordId = item.recordId;
        var type = item.type;
        var realname = item.realName;
        var name = item.name;
        var date = item.date;
        var status = item.status;
        var table = `
              <tr>
                <td class="text-center">
                  <strong>`+ name +`</strong>
                </td>
                
                <td class="text-center">
                  <strong>
                    <span name="number">`+ realname +`</span>
                  </strong>
                </td>
                <td class="text-center">
                  <strong>
                    <span name="number">`+ date +`</span>
                  </strong>
                </td>
                <td class="text-center">
                  <a href="javascript:void(0)" class="label label-success" id="status">已通过</a>
                </td>
                <td class="text-center">
                <a href="#modal_check" data-toggle="modal" title="查看" id="check" class="btn btn-effect-ripple btn-xs btn-info" onclick="check(`+ type +`,`+ recordId +`)">
                <i class="fa fa-eye"></i>
                </a>
                </td>  
              </tr>                            
              `
        $("#table").append(table);
      })

    },
    error: function (e) {
    }
  })
}

// 修改密码
$("#modifypwd").on("click",function(){
  var id = sessionStorage.id;
  var pwd = $("#pwd").val();
  var newpwd = $("#newpwd").val();
  var repwd = $("#repwd").val();
  if (newpwd != repwd) {
    alert("密码不一致");
  }
  $.ajax({
    url: ip + '/scm/users/password',
    type: 'POST',
    cache: false,
    data: {
      userId:id,
      OldPassword: pwd,
      NewPassword: repwd        
    },
    success: function (data) {
      console.log(data)
      if (data == 1) {
        alert("修改成功");
      } else if (data == 0) {
        alert("修改失败")
      }
    },
    error: function (data) {
      console.log(data)
    }
  });
})
