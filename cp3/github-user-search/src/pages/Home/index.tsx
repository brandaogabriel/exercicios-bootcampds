import React from 'react';
import ButtoIcon from '../../core/components/ButtoIcon';

import './styles.css';

const Home = (): JSX.Element => (
  <div className="home-content">
    <h1 className="home-content-title">
      Desafio do Capítulo 3, <br />
      Bootcamp DevSuperior
    </h1>
    <p className="home-content-description">
      Bem-vindos ao desafio do capítulo 3 do Bootcamp DevSuperior. Favor
      observar as instruções passadas no capítulo sobre a elaboração deste
      projeto.
      <br />
      Este design foi adaptado a partir de Ant Design System for Figma, de
      <br />
      Mateusz Wierzbicki:
      <span className="home-content-email"> antforfigma@gmail.com</span>
    </p>
    <ButtoIcon text={'Começar'} />
  </div>
);

export default Home;
