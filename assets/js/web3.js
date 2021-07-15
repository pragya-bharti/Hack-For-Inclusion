

import Portis from '@portis/web3';
import Web3 from 'web3';

export const portis = new Portis('4aba728d-1384-4fa4-a635-dd296790bc3d', 'mainnet');
export const web3 = new Web3(portis.provider);
