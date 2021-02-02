import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';

import Navbar from './core/components/Navbar';

const Routes = (): JSX.Element => (
  <BrowserRouter>
    <Navbar />
    <Switch>
      <Route path="/" exact>
        Home
      </Route>
    </Switch>
  </BrowserRouter>
);

export default Routes;
