document.addEventListener("DOMContentLoaded", function() {
    fetch('/api/quiz')
        .then(response => response.json())
        .then(data => {
            const quizQuestionsDiv = document.getElementById('quiz-questions');
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

        fetch('/api/submit', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(answers),
        })
            .then(response => response.json())
            .then(data => {
                alert(`10문제 중 ${data.score}문제 맞히셨습니다!`);
                window.location.href = '/main';
            });
    });
});