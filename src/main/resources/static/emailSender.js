document.getElementById('emailForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent default form submission

    var formData = new FormData(this);

    var attachment = document.getElementById('attachment').files[0];

    if (attachment) {
        // If attachment exists, use sendmail API
        sendWithAttachment(formData, attachment);
    } else {
        // If no attachment, use sendmailText API
        sendWithoutAttachment(formData);
    }
});

function sendWithAttachment(formData, attachment) {
    formData.append('file', attachment);

    fetch('http://localhost:8080/home/sendmail', {
        method: 'POST',
        body: formData
    })
    .then(response => {
        if (response.ok) {
            document.getElementById('message').innerText = 'Email sent successfully.';
        } else {
            document.getElementById('message').innerText = 'Failed to send email. Please try again.';
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

function sendWithoutAttachment(formData) {
    fetch('http://localhost:8080/home/sendmailText', {
        method: 'POST',
        body: formData
    })
    .then(response => {
        if (response.ok) {
            document.getElementById('message').innerText = 'Email sent successfully.';
        } else {
            document.getElementById('message').innerText = 'Failed to send email. Please try again.';
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
}
