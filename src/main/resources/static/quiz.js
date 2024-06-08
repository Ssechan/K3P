document.addEventListener("DOMContentLoaded", function() {
    const lec_selectors = document.querySelectorAll(".lec_selector");

    fetch('/api/quiz')
        .then(response => response.json())
        .then(data => {
            console.log('Received quiz data:', data);  // 디버깅 로그 추가

            const quizQuestionsDiv = document.getElementById('quiz-questions');
            if (!quizQuestionsDiv) {
                console.error('Element with id "quiz-questions" not found.');
                return;
            }

            data.questions.forEach((question, index) => {
                const card = document.createElement('div');
                card.className = 'card';

                const questionNumber = document.createElement('div');
                questionNumber.textContent = `Question ${index + 1}`;
                questionNumber.className = 'questionNumber'
                card.appendChild(questionNumber);

                const questionTitle = document.createElement('h2');
                questionTitle.textContent = `${question.question}`;
                card.appendChild(questionTitle);

                const optionsDiv = document.createElement('div');
                optionsDiv.className = 'options';

                question.options.forEach(option => {
                    const label = document.createElement('label');
                    const input = document.createElement('input');
                    input.type = 'radio';
                    input.name = `answer${index}`;
                    input.value = option;

                    label.appendChild(input);
                    label.appendChild(document.createTextNode(option));
                    optionsDiv.appendChild(label);
                });

                card.appendChild(optionsDiv);
                quizQuestionsDiv.appendChild(card);

                // question ID 저장용 input (hidden)
                const questionIdInput = document.createElement('input');
                questionIdInput.type = 'hidden';
                questionIdInput.name = `questionId${index}`;
                questionIdInput.value = question.id;
                card.appendChild(questionIdInput);
            });
        });

    document.getElementById('quiz-form').addEventListener('submit', function(event) {
        event.preventDefault();
        const formData = new FormData(this);
        const answers = {};
        for (let [key, value] of formData.entries()) {
            answers[key] = value;
        }
        console.log('Submitting answers:', answers); // 디버깅용 콘솔 로그

        fetch('/api/submit', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(answers),
        })
            .then(response => response.json())
            .then(data => {
                console.log('Response from server:', data); // 디버깅용 콘솔 로그
                const score = data.score;
                alert(`10문제 중 ${score}문제 맞히셨습니다!`);
                if (score >= 9) {
                    alert("축하해요! 퀴즈를 통과하셨습니다!");
                    updateLessonStatus();
                }
                window.location.href = '/main';
            })
            .catch(error => console.error('Error:', error));
    });

    function updateLessonStatus() {
        fetch('/api/completedLessons')
            .then(response => response.json())
            .then(data => {
                lec_selectors.forEach(selector => {
                    const selectorLessonId = selector.getAttribute('data-lesson-id');
                    if (data.completedLessons.includes(parseInt(selectorLessonId))) {
                        selector.style.backgroundColor = 'green';} // 통과한 강의는 초록색으로 표시
                });
            })
            .catch(error => console.error('Error updating lesson status:', error));
    }

});