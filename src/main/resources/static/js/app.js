import '../scss/app.scss';

import AOS from 'aos';
import 'aos/dist/aos.css'; // You can also use <link> for styles
AOS.init({
    duration: 1000,
    delay: 100,
});

import Typed from 'typed.js';
const options = {
    stringsElement: '#typed-strings',
    startDelay: 300,
    typeSpeed: 150
};
new Typed("#typed", options);

import 'animate.css';