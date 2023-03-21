function greetings() {

    const hamburger_menu = document.querySelector(".hamburger-menu");
    const container = document.querySelector(".container");

    hamburger_menu.addEventListener("click", () => {
    container.classList.toggle("active");
    });

    const slider = document.querySelector('.slider-container');
const slides = document.querySelectorAll('.slider-item');
const prevArrow = document.querySelector('.arrow-left');
const nextArrow = document.querySelector('.arrow-right');
const slideWidth = slides[0].offsetWidth;
let position = 0;

function moveSlider(direction) {
  if (direction === 'left') {
    position += slideWidth;
  } else {
    position -= slideWidth;
  }
  
  if (position > 0) {
    position = -(slides.length - 1) * slideWidth;
  } else if (position < -(slides.length - 1) * slideWidth) {
    position = 0;
  }
  
  slider.style.transform = `translateX(${position}px)`;
}

prevArrow.addEventListener('click', () => moveSlider('left'));
nextArrow.addEventListener('click', () => moveSlider('right'));

    
}