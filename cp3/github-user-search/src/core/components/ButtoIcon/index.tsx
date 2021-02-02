import React from 'react';

import './styles.css';

type Props = {
  text: string;
};

const ButtoIcon = ({ text }: Props): JSX.Element => (
  <button className="btn">
    <h5 className="btn-text">{text}</h5>
  </button>
);

export default ButtoIcon;
