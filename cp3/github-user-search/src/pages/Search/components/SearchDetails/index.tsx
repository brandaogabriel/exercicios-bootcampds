import React from 'react';
import ButtoIcon from '../../../../core/components/ButtoIcon';
import { GithubUser } from '../../../../core/types/GithubUser';

import './styles.css';

type Props = {
  gitHubUser: GithubUser;
};

const SearchDetails = ({ gitHubUser }: Props): JSX.Element => {
  return (
    <div className="user-info-container">
      <div className="user-infor-img">
        <img src={`${gitHubUser.avatar_url}`} className="user-photo" />
        <div className="btn-getInfo">
          <a href="http://github.com">
            <ButtoIcon text={'Ver perfil'} />
          </a>
        </div>
      </div>

      <div className="user-container">
        <div className="user-info-stats">
          <span className="user-stat-repo">
            Repositórios públicos: {gitHubUser.public_repos}
          </span>
          <span className="user-stat-repo">
            Seguidores: {gitHubUser.followers}
          </span>
          <span className="user-stat-repo">
            Seguindo: {gitHubUser.following}
          </span>
        </div>

        <div className="user-info-details-container">
          <h1 className="user-info-details-title">Informações</h1>
          <p className="user-infor-details">
            <span className="user-info-details-attribute">Empresa:</span>{' '}
            {gitHubUser.company}
          </p>
          <p className="user-infor-details">
            <span className="user-info-details-attribute">Website/Blog:</span>{' '}
            {gitHubUser.blog}
          </p>
          <p className="user-infor-details">
            <span className="user-info-details-attribute">Localidade:</span>{' '}
            {gitHubUser.location}
          </p>
          <p className="user-infor-details">
            <span className="user-info-details-attribute">Membro desde:</span>{' '}
            {gitHubUser.created_at}
          </p>
        </div>
      </div>
    </div>
  );
};

export default SearchDetails;
