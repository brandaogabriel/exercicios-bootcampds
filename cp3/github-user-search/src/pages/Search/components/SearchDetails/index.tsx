import React from 'react';

import dayjs from 'dayjs';
import 'dayjs/locale/pt-br';
import relativeTime from 'dayjs/plugin/relativeTime';

dayjs.locale('pt-br');
dayjs.extend(relativeTime);

import ButtoIcon from 'core/components/ButtonIcon';
import { GithubUser } from 'core/types/GithubUser';

import './styles.css';
import { Link } from 'react-router-dom';

function formatDateFromNow(date: string): string {
  return dayjs(date).format('DD/MM/YYYY');
}

type Props = {
  gitHubUser: GithubUser;
};

const SearchDetails = ({ gitHubUser }: Props): JSX.Element => {
  return (
    <div className="user-info-container">
      <div className="user-infor-img">
        <img src={`${gitHubUser.avatar_url}`} className="user-photo" />
        <div className="btn-getInfo">
          <Link
            to={{ pathname: `https://github.com/${gitHubUser.login}` }}
            target="_blank"
          >
            <ButtoIcon text={'Ver perfil'} />
          </Link>
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
            {formatDateFromNow(gitHubUser.created_at)}
          </p>
        </div>
      </div>
    </div>
  );
};

export default SearchDetails;
