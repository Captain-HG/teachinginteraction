 var totalpage, pagesize, cpage, count, curcount, outstr;
    //初始化
    cpage = 1;
    pagesize = 25;
    outstr = "";

    GoToPage(1, '', '');

    function GoToPage(page, field, name) {
        $("#tb_content").empty();
        $.post("/Home/LabsListData", { page: page, rows: pagesize, N: name, F: field }, function (data) {
            var zongshu = data.zongshu;
            var Total = (zongshu + pagesize - 1) / pagesize;

            var num = 0;//data.list.length;
            var start = 1 + pagesize * (page - 1);
            var end = pagesize * (page - 1) + num;

            if (zongshu > 0) {
                num = data.list.length;
            }

            for (var o in data.list) {
                $("#tb_content").append('<tr class="odd selected"><td style="width: 48px; text-align: center;">' + start + '</td><td style="width: 180px;"><a style="cursor:pointer;" href="/Home/LabInfo?id=' + data.list[o].ChildID + '">' + data.list[o].ChildName + '</a></td><td>' + data.list[o].ServiceName + '</td><td style="width: 70px;">' + data.list[o].People + '</td><td>' + data.list[o].OfficeTel + '</td></tr>');
                $("#tb_content").append('<tr class="odd selectedtwo"><td colspan="5" style="border-top:0px;padding-left: 50px;padding-right: 30px;">' + (data.list[o].Service.length > 220 ? data.list[o].Service.substring(0, 220) + "..." : data.list[o].Service) + '</td></tr>');
                start++;//<td>' + data.list[o].ChildPeopleMail + '</td>
            }
            if (zongshu == 0) {
                $("#div_summary").html("共 0 条.");
            } else {
                $("#div_summary").html("第 " + (1 + pagesize * (page - 1)) + "-" + (pagesize * (page - 1) + num) + " 条, 共 " + zongshu + " 条.");
            }

            //初始化分页
            cpage = page;
            totalpage = Total;

            setpage(field, name);    //调用分页

        });
    }

    function setpage(field, name) {
        if (totalpage >= 2 && totalpage <= 6) {        //总页数小于五页
            outstr = outstr + "<li class=\"first\"><a onclick=\"GoToPage(" + 1 + ",'" + field + "','" + name + "')\">&lt;&lt; 首页</a></li>\n";
            for (count = 1; count <= totalpage; count++) {
                if (count != cpage) {
                    outstr = outstr + "<li class=\"page\"><a onclick=\"GoToPage(" + count + ",'" + field + "','" + name + "')\">" + count + "</a></li>\n";
                } else {
                    outstr = outstr + "<li class=\"page active\"><a onclick=\"GoToPage(" + count + ",'" + field + "','" + name + "')\" >" + count + "</a></li>\n";
                }
            }
            outstr = outstr + "<li class=\"last\"><a onclick=\"GoToPage(" + parseInt(totalpage) + ",'" + field + "','" + name + "')\">末页 &gt;&gt;</a></li>\n";
        }
        if (totalpage > 6) {        //总页数大于十页
            if (parseInt((cpage - 1) / 5) == 0) {
                for (count = 1; count <= 5; count++) {
                    if (count != cpage) {
                        outstr = outstr + "<li class=\"page\"><a onclick=\"GoToPage(" + count + ",'" + field + "','" + name + "')\" class='page-numbers' >" + count + "</a></li>\n";
                    } else {
                        outstr = outstr + "<li class=\"page active\"><a onclick=\"GoToPage(" + count + ",'" + field + "','" + name + "')\" >" + count + "</a></li>\n";
                    }
                }
                outstr = outstr + "<li class=\"next\"><a onclick=\"GoToPage(" + count + ",'" + field + "','" + name + "')\" >后页 &gt;</a></li>\n";
                outstr = outstr + "<li class=\"last\"><a onclick=\"GoToPage(" + parseInt(totalpage) + ",'" + field + "','" + name + "')\">末页 &gt;&gt;</a></li>\n";
            }
            else if (parseInt((cpage - 1) / 5) == parseInt(totalpage / 5)) {
                outstr = outstr + "<li class=\"first\"><a onclick=\"GoToPage(" + 1 + ",'" + field + "','" + name + "')\">&lt;&lt; 首页</a></li>\n";
                outstr = outstr + "<li class=\"previous\"><a onclick=\"GoToPage(" + (parseInt((cpage - 1) / 5) * 5) + ",'" + field + "','" + name + "')\">&lt; 前页</a></li>\n";
                for (count = parseInt(totalpage / 5) * 5 + 1; count <= totalpage; count++) {
                    if (count != cpage) {
                        outstr = outstr + "<li class=\"page\"><a onclick=\"GoToPage(" + count + ",'" + field + "','" + name + "')\" class='page-numbers' >" + count + "</a></li>\n";
                    } else {
                        outstr = outstr + "<li class=\"page active\"><a onclick=\"GoToPage(" + count + ",'" + field + "','" + name + "')\" >" + count + "</a></li>\n";
                    }
                }
            }
            else {
                outstr = outstr + "<li class=\"first\"><a onclick=\"GoToPage(" + 1 + ",'" + field + "','" + name + "')\">&lt;&lt; 首页</a></li>\n";
                outstr = outstr + "<li class=\"previous\"><a onclick=\"GoToPage(" + (parseInt((cpage - 1) / 5) * 5) + ",'" + field + "','" + name + "')\">&lt; 前页</a></li>\n";
                for (count = parseInt((cpage - 1) / 5) * 5 + 1; count <= parseInt((cpage - 1) / 5) * 5 + 5; count++) {
                    if (count != cpage) {
                        outstr = outstr + "<li class=\"page\"><a onclick=\"GoToPage(" + count + ",'" + field + "','" + name + "')\" class='page-numbers' >" + count + "</a></li>\n";
                    } else {
                        outstr = outstr + "<li class=\"page active\"><a onclick=\"GoToPage(" + count + ",'" + field + "','" + name + "')\" >" + count + "</a></li>\n";
                    }
                }
                outstr = outstr + "<li class=\"next\"><a onclick=\"GoToPage(" + count + ",'" + field + "','" + name + "')\">后页 &gt;</a></li>\n";
                outstr = outstr + "<li class=\"last\"><a onclick=\"GoToPage(" + parseInt(totalpage) + ",'" + field + "','" + name + "')\">末页 &gt;&gt;</a></li>\n";
            }
        }

        if (totalpage > 1) {
            $("#div_page").empty();
            $("#div_page").append(outstr);
        }
        outstr = "";
    }

    function Search() {
        GoToPage(1, $("#sel_field").val(), $("#txt_servicename").val());
    }
