document.addEventListener('DOMContentLoaded', () => {
    // Mode Switching Logic
    const modeBtns = document.querySelectorAll('.mode-btn');
    const forms = document.querySelectorAll('.booking-form');

    modeBtns.forEach(btn => {
        btn.addEventListener('click', () => {
            modeBtns.forEach(b => b.classList.remove('active'));
            forms.forEach(f => f.classList.remove('active'));

            btn.classList.add('active');
            const mode = btn.dataset.mode;
            document.getElementById(`${mode}-form`).classList.add('active');
        });
    });

    // Theme Toggle Logic
    const themeToggle = document.getElementById('theme-toggle');
    const body = document.body;

    themeToggle.addEventListener('click', () => {
        body.classList.toggle('dark-theme');
        const isDark = body.classList.contains('dark-theme');
        themeToggle.textContent = isDark ? '☀️ Light' : '🌙 Dark';
        localStorage.setItem('theme', isDark ? 'dark' : 'light');
    });

    // Check saved theme
    if (localStorage.getItem('theme') === 'dark') {
        body.classList.add('dark-theme');
        themeToggle.textContent = '☀️ Light';
    }

    // Booking Submission
    forms.forEach(form => {
        form.addEventListener('submit', (e) => {
            e.preventDefault();
            const inputs = form.querySelectorAll('input, select');
            const booking = {
                id: Date.now(),
                type: form.id.replace('-form', ''),
                timestamp: new Date().toLocaleString()
            };

            inputs.forEach(input => {
                const label = input.previousElementSibling.textContent;
                booking[label] = input.value;
            });

            saveBooking(booking);
            form.reset();
            alert('Ticket booked successfully!');
            renderBookings();
        });
    });

    // Support Ticket Submission
    document.getElementById('support-form').addEventListener('submit', (e) => {
        e.preventDefault();
        const name = document.getElementById('support-name').value;
        const issue = document.getElementById('support-issue').value;
        const ticketId = Math.floor(1000 + Math.random() * 9000);

        const ticket = {
            id: ticketId,
            name,
            issue,
            status: 'Open'
        };

        const tickets = JSON.parse(localStorage.getItem('support_tickets') || '[]');
        tickets.push(ticket);
        localStorage.setItem('support_tickets', JSON.stringify(tickets));

        document.getElementById('support-form').reset();
        alert(`Support ticket raised! ID: ${ticketId}`);
        renderSupportTickets();
    });

    // Initialize View
    renderBookings();
    renderSupportTickets();
    renderAverageRating();
});

// Helper Functions
function saveBooking(booking) {
    const bookings = JSON.parse(localStorage.getItem('bookings') || '[]');
    bookings.push(booking);
    localStorage.setItem('bookings', JSON.stringify(bookings));
}

function renderBookings() {
    const container = document.getElementById('bookings-container');
    const bookings = JSON.parse(localStorage.getItem('bookings') || '[]');

    if (bookings.length === 0) return;

    container.innerHTML = bookings.reverse().map(b => `
        <div class="booking-card">
            <span class="tag">${b.type}</span>
            <h4 style="margin-bottom: 0.5rem;">${b['Passenger Name'] || b['Passenger'] || 'Alex Smith'}</h4>
            <p class="text-muted" style="font-size: 0.9rem;">${b['Source'] || b['From'] || ''} → ${b['Destination'] || b['To'] || 'Trip'}</p>
            <p class="text-muted" style="font-size: 0.8rem; margin-top: 1rem;">
                <strong>Date:</strong> ${b['Date'] || b.timestamp}<br>
                <strong>Payment:</strong> ${b['Payment'] || b['Payment Mode'] || 'N/A'}
            </p>
        </div>
    `).join('');
}

// Rating Logic
let selectedRating = 0;
const stars = document.querySelectorAll('.star');

stars.forEach(star => {
    star.addEventListener('click', () => {
        selectedRating = parseInt(star.dataset.value);
        stars.forEach((s, idx) => {
            s.classList.toggle('active', idx < selectedRating);
        });
    });
});

function submitRating() {
    if (selectedRating === 0) {
        alert('Please select a star rating.');
        return;
    }
    const feedback = document.getElementById('feedback-text').value;
    const ratings = JSON.parse(localStorage.getItem('ratings') || '[]');
    ratings.push({ score: selectedRating, feedback });
    localStorage.setItem('ratings', JSON.stringify(ratings));

    alert('Thank you for your feedback!');
    document.getElementById('feedback-text').value = '';
    selectedRating = 0;
    stars.forEach(s => s.classList.remove('active'));
    renderAverageRating();
}

function renderAverageRating() {
    const ratings = JSON.parse(localStorage.getItem('ratings') || '[]');
    if (ratings.length === 0) return;

    const avg = (ratings.reduce((sum, r) => sum + r.score, 0) / ratings.length).toFixed(1);
    document.getElementById('avg-rating').textContent = `Average Customer Rating: ${avg}/5 (${ratings.length} reviews)`;
}

function renderSupportTickets() {
    const container = document.getElementById('support-tickets');
    const tickets = JSON.parse(localStorage.getItem('support_tickets') || '[]');

    if (tickets.length === 0) return;

    container.innerHTML = '<h4>Your Support Tickets</h4>' + tickets.map(t => `
        <div style="background: rgba(0,0,0,0.2); padding: 1rem; border-radius: 0.5rem; margin-top: 0.5rem; font-size: 0.9rem;">
            <strong>#${t.id}</strong> - ${t.status}<br>
            <span class="text-muted">${t.issue}</span>
        </div>
    `).join('');
}
