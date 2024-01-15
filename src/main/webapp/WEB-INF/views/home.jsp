<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
	<title>Home</title>
    <style>
        #btnDiv { text-align: center; margin-top: 20px; }
        .btns { display: inline-block; padding: 0 10px; height: 28px; line-height: 26px; text-align: center; vertical-align: middle; border-radius: 3px; border: 1px solid transparent; font-weight: 500; }
        .btns.save { background: #139dc8; color: #fff; cursor: pointer; }
        .btns.back { background: #fff; border: 1px solid #199bc4; color: #199bc4; }
    </style>
</head>
<body>
	<h1>
		Hello world!
	</h1>
	<h3>Here is my Nest. Have a good time.</h3>	
	
	<P>  The time on the server is ${serverTime}. </P>
	<a href="create" class="btns back">글쓰기</a>

    <table>
        <colgroup>
            <col style="width: 5%;" />
            <col style="width: 80%;" />
            <col style="width: 15%;" />
        </colgroup>
        <thead>
            <tr>
                <th scope="col">번호</th>
                <th scope="col">제목</th>
                <th scope="col">날짜</th>
            </tr>
        </thead>

        <!--/* 리스트 데이터 렌더링 영역 */-->
        <tbody id="posts">

        </tbody>
    </table>

    <script>

        window.onload = async () => {
            findAllPost();
        }
        
        // 전체 게시글 조회
        async function findAllPost() {

            // 1. API 호출
            const url = '/controller/api/posts';
            const response = await fetch(url);
//            console.log(response);
            const list = await response.json();
//            console.log(list);
            // 2. 데이터가 없는 경우, 로직 종료
            if (list.length < 1) {
                document.querySelector('#posts').innerHTML = '<tr><td colspan="2">검색된 결과가 없습니다.</td></tr>';
                return false;
            }

            // 3. 리스트 HTML 세팅
            let html = '';
            list.forEach((item, index) => {
                html += '<tr><td>'+ (index + 1)+'</td>';
                html += '<td class="left"><a href="read/';
                html += item.bno;
                html += '">';
                html += item.title;
                html += '</a></td>';
                html += '<td>'+ item.date + '</td>';
                html += '</tr>';
              
            });
 //           console.log(html);
            // 4. 리스트 HTML 렌더링
            document.querySelector('#posts').innerHTML = html;
        }

    </script>

</body>
</html>
