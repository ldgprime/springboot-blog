/**
 * 
 */
	//삭제는 get으로 하면 쉽지만 공격당함
	$('#post--delete--submit').on('click', function() {
		var id = $('#post--delete--submit').val();

		$.ajax({
			type : 'DELETE',
			url : '/post/delete/' + id,			
			dataType : 'json'
		}).done(function(r) {		
			if (r.statusCode == 200) {				
				alert('글삭제에 성공했습니다!')
				location.href = '/'
			} else {		
				alert('글삭제에 실패했습니다!')
			}
		}).fail(function(r) {		
			alert('글삭제에 실패했습니다!')

		})

	})
	
	
		
	$('#comment--save--submit').on('click', function() {
		
		var data = {
			userId:$('#userId').val(),
			postId:	$('#postId').val(),
			content: $('#content').val()
		}
		
		$.ajax({
			type : 'POST',
			url : '/comment/write',
			data:JSON.stringify(data),
			contentType:'application/json; chartset=utf-8',
			dataType : 'json'
		}).done(function(r) {		
			if (r.status.statusCode == 200) {				
				alert('댓글쓰기에 성공했습니다!')			
				makeCommentItem(r);
			} else {		
				alert('댓글쓰기에 실패했습니다!')
			}
		}).fail(function(r) {		
			alert('댓글쓰기에 실패했습니다!')
		
		})
	
	})	
	
	
	function makeCommentItem(r){		
		var comment_item =`<div id="comment--item--${r.id}">`;
		comment_item +=`<span class="comment--username"> 작성자: ${r.username} </span>`;
		comment_item +=`<span class="comment--content"> ${r.content} </span> `;
		comment_item +=`<button onclick="commentDelete(${r.id})"> 삭제 </button>`;
		comment_item +=`</div>`;		

		$('#comment--items').prepend(comment_item);
		
	}
	
	function commentDelete(commentid){		
		$.ajax({
			type : 'DELETE',
			url : '/comment/delete/' + commentid,			
			dataType : 'json'
		}).done(function(r) {		
			if (r.statusCode == 200) {				
				alert('댓글삭제에 성공했습니다!')
				$('#comment--item--'+commentid).remove();
			} else {		
				alert('댓글삭제에 실패했습니다!')
			}
		}).fail(function(r) {		
			alert('댓글삭제에 실패했습니다!')
		})
	}
	
	