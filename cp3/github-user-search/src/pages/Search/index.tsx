import React, { useState } from 'react';

import ButtoIcon from 'core/components/ButtonIcon';
import { GithubUser } from 'core/types/GithubUser';
import getUserInfoFromGithub from 'core/utils/request';

import ImageLoader from './components/Loaders/ImageLoader';
import InfoLoader from './components/Loaders/InfoLoader';
import SearchDetails from './components/SearchDetails';

import './styles.css';

const Search = (): JSX.Element => {
  const [isSearching, setIsSearching] = useState<boolean>(false);
  const [userName, setUserName] = useState('');
  const [gitHubUser, setGitHubUser] = useState<GithubUser>({
    public_repos: 0,
    followers: 0,
    following: 0,
    company: '',
    blog: '',
    location: '',
    created_at: '',
    avatar_url: '',
  });

  const handleOnChange = (event: React.ChangeEvent<HTMLInputElement>): void => {
    setUserName(event.target.value);
  };

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>): void => {
    event.preventDefault();
    setIsSearching(true);
    getUserInfoFromGithub(userName)
      .then(response => {
        setGitHubUser(response.data);
      })
      .finally(() => setIsSearching(false));
  };

  return (
    <>
      <div className="search-container">
        <h1 className="search-title">Encontre um perfil Github</h1>
        <form onSubmit={handleSubmit}>
          <input
            name="userName"
            value={userName}
            type="text"
            placeholder="Usuário Github"
            onChange={handleOnChange}
            className="input-user-name"
          />
          <div className="btn-submit">
            <ButtoIcon text={'Encontrar'} />
          </div>
        </form>
      </div>
      {isSearching ? (
        <div className="loader">
          <ImageLoader />
          <InfoLoader />
        </div>
      ) : (
        <SearchDetails gitHubUser={gitHubUser} />
      )}
    </>
  );
};

export default Search;
