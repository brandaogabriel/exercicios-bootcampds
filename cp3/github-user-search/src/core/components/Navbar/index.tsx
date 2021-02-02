import React from 'react';

import { Link } from 'react-router-dom';

import './styles.css';

const Navbar = (): JSX.Element => (
  <nav className="navbar">
    <Link to="/" className="navbar-link">
      <h2 className="navbar-text">Bootcamp DevSuperior</h2>
    </Link>
  </nav>
);

export default Navbar;
