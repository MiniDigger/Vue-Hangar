<template>
  <div>
    <b-jumbotron
      header="Hangar"
      lead="Launch your Paper Planes/Plugins from this awesome hangar!"
    >
      <p>For more information visit website</p>
      <b-button variant="primary" href="#">More Info</b-button>
    </b-jumbotron>

    <section>
      <h1>Featured Resources</h1>
      <b-row>
        <b-col
          v-for="(resource, idx) in featured"
          :key="'resource-' + idx"
          cols="4"
        >
          <FeaturedResource
            :image="resource.image"
            :name="resource.name"
            :description="resource.description"
            :url="resource.url"
            class="featured-resource"
          />
        </b-col>
      </b-row>
    </section>
  </div>
</template>

<script>
import FeaturedResource from '~/components/FeaturedResource'

export default {
  components: { FeaturedResource },
  data() {
    return {
      featured: [
        {
          image:
            'https://www.stevens.edu/sites/stevens_edu/files/styles/news_detail/public/shutterstock_1165123768.jpg',
          name: 'WorldEdit',
          description:
            'You can use it "a little" to copy and paste one building from one map to another or you can use to sculpt whole biomes and build cities. It\'s great for both your single player/local server OR your dedicated Minecraft server. Use it to build things or fix things.',
          url: '#',
        },
        {
          image:
            'https://media.nesta.org.uk/images/Predictions-2019_Twitter_02.width-1200.png',
          name: 'WorldGuard',
          description:
            'WorldGuard is a powerful plugin with a large bag of tricks for server owners, server map makers, regular survival servers, and everyone in between!',
          url: '#',
        },
        {
          image:
            'https://www.pngitem.com/pimgs/m/425-4259189_transparent-cool-dog-png-dj-pug-png-download.png',
          name: 'MiniMessage',
          description:
            'Simple library that implements an easy to use textual format to send rich json messages.',
          url: '#',
        },
        {
          image:
            'https://thumbs.dreamstime.com/b/cool-man-shield-gaming-logo-vector-cool-man-shield-gaming-logo-vector-design-your-company-brand-132014349.jpg',
          name: 'Guilds',
          description:
            'The Guilds Project was created to offer a RPG type system to servers. It was inspired by players like you who enjoy creating a fun and exciting environment for your server. Guilds allows players to join interactive groups of other players, forge their own communities on your server, and compete with other guilds for dominance and control.',
          url: '#',
        },
        {
          image:
            'https://image.freepik.com/free-vector/cool-majestic-mint-wolf_22252-48.jpg',
          name: 'ChatControl',
          description:
            'ChatControl is chat management and formatting solution for bukkit that significantly reduces amount of spam, ads, swearing and bots on your server! Create custom rules and handlers for complete control over the chat. This also comes with many other, often unique features, see the list below!',
          url: '#',
        },
        {
          image:
            'https://upload.wikimedia.org/wikipedia/commons/e/e2/Reeipublic_Banana.gif',
          name: 'EssentialsX',
          description:
            'EssentialsX provides several performance enhancements and fixes that are currently not available in Essentials and Spigot-Essentials, most importantly fixed mob spawner support for 1.8+ servers.',
          url: '#',
        },
      ],
    }
  },
}
</script>

<style lang="scss" scoped>
.featured-resource {
  margin-bottom: 15px;
}
.jumbotron {
  background-color: unset;
}
</style>
