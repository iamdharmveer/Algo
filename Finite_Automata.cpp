/*input
AABAACAADAABAAABAA A
*/
#include<bits/stdc++.h>
using namespace std;
#define ll long long int
#define _ ios_base::sync_with_stdio(0);	cin.tie(0);	cout.tie(0);
#define mod 1000000000+7
#define limit 100000+5
#define characters 256
ll getNextState(string pattern, ll state, ll x){
	if(state < pattern.length() && x == pattern[state])
		return state+1;
	ll nextstate, i;
	for(nextstate =state;nextstate>0;nextstate--){
		if(pattern[nextstate-1] == x){
			for(i =0;i<nextstate-1;++i){
				if(pattern[i] != pattern[state-nextstate+1+i])
					break;
			}
			if(i == nextstate-1)
				return nextstate;
		}
	}
}
ll transitional_function(string pattern, ll TF[][characters]){
	ll state, x;
	for(state =0;state<=pattern.length();++state){
		for(x =0;x<characters;++x){
			TF[state][x] =getNextState(pattern, state, x);
		}
	}
}
void finite_automaton_matcher(string text, string pattern){
	ll TF[pattern.length()+1][characters];
	transitional_function(pattern, TF);
	// for(ll i =0;i<pattern.length()+1;++i){
	// 	for(ll j =0;j<characters;++j)
	// 		cout<<TF[i][j]<<" ";
	// 	cout<<endl;
	// }
	// cout<<endl<<endl;
	ll i, q =0;
	for(i =0;i<text.length();++i){
		q =TF[q][text[i]];
		if(q == pattern.length()){	
			cout<<i-pattern.length()+1<<"\n";
			// break;
		}
	}

}
int main()
{	_;
	string text, pattern;
	cin>>text>>pattern;
	finite_automaton_matcher(text, pattern);
return 0;
}