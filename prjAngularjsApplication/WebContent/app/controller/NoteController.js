app.controller('AddNoteController',function ($scope, $location, $routeParams, NoteModel) {
	var chapterId = $routeParams.chapterId;
	$scope.cancel = function() {
		$location.path('/chapter/' + chapterId);
	};
	$scope.createNote = function() {
		NoteModel.addNote(chapterId, $scope.note.content);
		$location.path('/chapter/' + chapterId);
	};
});

app.controller('DeleteNoteController',function ($scope, $location, $routeParams, NoteModel) {
			var chapterId = $routeParams.chapterId;
			NoteModel.deleteNote(chapterId, $routeParams.noteId);
			$location.path('/chapter/' + chapterId);
		});